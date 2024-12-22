package com.project.storeSystem.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.storeSystem.Service.PGPFileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyDecryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider;
import org.bouncycastle.openpgp.operator.bc.BcPublicKeyDataDecryptorFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class pgpFileServiceImpl implements PGPFileService {
    public static final Logger logger = LogManager.getLogger(pgpFileServiceImpl.class);

    public Object decryptFile(MultipartFile file, String privateKeyPath, String passphrase) throws Exception {
        File tmpEncryptedFile = null;
        File tmpDecryptedFile = null;
        try {
            tmpEncryptedFile = File.createTempFile("encrypted", ".asc");
            file.transferTo(tmpEncryptedFile);

            tmpDecryptedFile = File.createTempFile("decrypted", ".json");

            // Log input files for debugging
            logger.debug("Encrypted file path: " + tmpEncryptedFile.getAbsolutePath());
            logger.debug("Decrypted file path: " + tmpDecryptedFile.getAbsolutePath());

            // Decrypt the file
            decryptFile(tmpEncryptedFile.getAbsolutePath(), tmpDecryptedFile.getAbsolutePath(), privateKeyPath, passphrase);

            // Read decrypted content
            String decryptedContent = new String(java.nio.file.Files.readAllBytes(tmpDecryptedFile.toPath()), StandardCharsets.UTF_8);

            logger.debug("Decrypted Content: " + decryptedContent);
            if (!decryptedContent.trim().startsWith("{") && !decryptedContent.trim().startsWith("[")) {
                throw new Exception("Decrypted content is not valid JSON: " + decryptedContent);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(tmpDecryptedFile, Object.class);
        } catch (Exception e) {
            logger.error("Error during file decryption", e);
            throw new Exception("Error during file decryption", e);  // Re-throwing the exception to handle it further up the chain
        } finally {
            // Ensure the temporary files are deleted, check if deletion is successful
            if (tmpEncryptedFile != null && tmpEncryptedFile.exists() && !tmpEncryptedFile.delete()) {
                logger.warn("Failed to delete temporary encrypted file: " + tmpEncryptedFile.getAbsolutePath());
            }
            if (tmpDecryptedFile != null && tmpDecryptedFile.exists() && !tmpDecryptedFile.delete()) {
                logger.warn("Failed to delete temporary decrypted file: " + tmpDecryptedFile.getAbsolutePath());
            }
        }
    }

//    private void decryptFile(String encryptedFilePath, String outputFilePath, String privateKeyPath, String passphrase) throws Exception {
//        try (FileInputStream keyIn = new FileInputStream(privateKeyPath);
//             FileInputStream encryptedFile = new FileInputStream(encryptedFilePath);
//             FileOutputStream outputFile = new FileOutputStream(outputFilePath)) {
//
//            // Logging the start of decryption process
//            logger.debug("Starting decryption using private key: " + privateKeyPath);
//
//            PGPSecretKeyRingCollection secretKeys = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(keyIn), new BcKeyFingerprintCalculator());
//
//            PGPObjectFactory objectFactory = new PGPObjectFactory(PGPUtil.getDecoderStream(encryptedFile), new BcKeyFingerprintCalculator());
//            Object obj = objectFactory.nextObject();
//
//            if (!(obj instanceof PGPEncryptedDataList)) {
//                obj = objectFactory.nextObject();
//            }
//
//            PGPEncryptedDataList encryptedDataList = (PGPEncryptedDataList) obj;
//            PGPPrivateKey privateKey = null;
//            PGPPublicKeyEncryptedData encryptedData = null;
//
//            // Log the list of encrypted data objects
//            logger.debug("Found " + encryptedDataList.size() + " encrypted data entries.");
//
//            for (PGPEncryptedData data : encryptedDataList) {
//                PGPPublicKeyEncryptedData pked = (PGPPublicKeyEncryptedData) data;
//                privateKey = findPrivateKey(secretKeys, pked.getKeyID(), passphrase.toCharArray());
//
//                if (privateKey != null) {
//                    encryptedData = pked;
//                    logger.debug("Private key found and used for decryption.");
//                    break;
//                }
//            }
//
//            if (privateKey == null) {
//                logger.error("Private key for decryption not found.");
//                throw new IllegalArgumentException("Private key for decryption not found.");
//            }
//
//            InputStream clearData = encryptedData.getDataStream(new BcPublicKeyDataDecryptorFactory(privateKey));
//            try (OutputStreamWriter writer = new OutputStreamWriter(outputFile, StandardCharsets.UTF_8)) {
//                byte[] buffer = new byte[1 << 16];
//                int bytesRead;
//                while ((bytesRead = clearData.read(buffer)) != -1) {
//                    writer.write(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
//                }
//            }
//            byte[] buffer = new byte[1 << 16];
//            int bytesRead;
//
//            while ((bytesRead = clearData.read(buffer)) != -1) {
//                outputFile.write(buffer, 0, bytesRead);
//            }
//
//            logger.debug("Decryption completed successfully.");
//        }
//    }

    private void decryptFile(String encryptedFilePath, String outputFilePath, String privateKeyPath, String passphrase) throws Exception {
        try (FileInputStream keyIn = new FileInputStream(privateKeyPath);
             FileInputStream encryptedFile = new FileInputStream(encryptedFilePath);
             FileOutputStream outputFile = new FileOutputStream(outputFilePath)) {

            // Logging the start of decryption process
            logger.debug("Starting decryption using private key: " + privateKeyPath);

            // Load secret keys
            PGPSecretKeyRingCollection secretKeys = new PGPSecretKeyRingCollection(
                    PGPUtil.getDecoderStream(keyIn),
                    new BcKeyFingerprintCalculator()
            );

            // Parse encrypted data
            PGPObjectFactory objectFactory = new PGPObjectFactory(
                    PGPUtil.getDecoderStream(encryptedFile),
                    new BcKeyFingerprintCalculator()
            );

            Object obj = objectFactory.nextObject();
            if (!(obj instanceof PGPEncryptedDataList)) {
                obj = objectFactory.nextObject(); // Skip other headers
            }

            PGPEncryptedDataList encryptedDataList = (PGPEncryptedDataList) obj;
            PGPPrivateKey privateKey = null;
            PGPPublicKeyEncryptedData encryptedData = null;

            // Find the correct private key for decryption
            for (PGPEncryptedData data : encryptedDataList) {
                PGPPublicKeyEncryptedData pked = (PGPPublicKeyEncryptedData) data;
                privateKey = findPrivateKey(secretKeys, pked.getKeyID(), passphrase.toCharArray());
                if (privateKey != null) {
                    encryptedData = pked;
                    logger.debug("Private key found and used for decryption.");
                    break;
                }
            }

            if (privateKey == null) {
                logger.error("Private key for decryption not found.");
                throw new IllegalArgumentException("Private key for decryption not found.");
            }

            // Decrypt data
            try (InputStream clearData = encryptedData.getDataStream(
                    new BcPublicKeyDataDecryptorFactory(privateKey))) {
                byte[] buffer = new byte[8192]; // Use a reasonable buffer size
                int bytesRead;
                while ((bytesRead = clearData.read(buffer)) != -1) {
                    outputFile.write(buffer, 0, bytesRead); // Write directly to file
                }
            }

            logger.debug("Decryption completed successfully.");
        } catch (Exception e) {
            logger.error("Error during decryption", e);
            throw e;
        }
    }


    private PGPPrivateKey findPrivateKey(PGPSecretKeyRingCollection secretKeys, long keyID, char[] passphrase) throws PGPException {
        PGPSecretKey secretKey = secretKeys.getSecretKey(keyID);

        if (secretKey == null) {
            logger.error("No secret key found for key ID: " + keyID);
            return null;
        }

        // Log key extraction
        logger.debug("Extracting private key for key ID: " + keyID);
        return secretKey.extractPrivateKey(new BcPBESecretKeyDecryptorBuilder(new BcPGPDigestCalculatorProvider()).build(passphrase));
    }
}
