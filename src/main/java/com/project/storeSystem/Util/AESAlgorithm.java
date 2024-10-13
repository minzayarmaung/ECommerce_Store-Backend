package com.project.storeSystem.Util;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class AESAlgorithm {
    public static String KEY = "";
    public static String IV = "";

    public static boolean readAESKey() {
        boolean exist = false;
        String[] keys = new String[2];
        String filePath = "E:\\PointStar_Mobile_Project\\backend\\storeSystem\\src\\main\\resources\\config\\AESConfig.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            keys[0] = reader.readLine();
            keys[1] = reader.readLine();

            KEY = keys[0];
            IV = keys[1];

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!KEY.isEmpty() && !IV.isEmpty()) {
            exist = true;
        }
        return exist;
    }

    public static String encryptString(String value)  {
        boolean isExist = readAESKey();

        if(isExist){
            byte[] keyBytes = KEY.getBytes(StandardCharsets.UTF_8);
            byte[] ivBytes = IV.getBytes(StandardCharsets.UTF_8);

            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivBytes);
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, paramSpec);
                // return new String (cipher.doFinal(value.getBytes("UTF-8")));
                return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes("UTF-8")));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return "Error Encrypting Data";
    }

    public static String decryptString(String value){
        boolean isExist = readAESKey();

        if(isExist){

            byte[] keyBytes = KEY.getBytes(StandardCharsets.UTF_8);
            byte[] ivBytes = IV.getBytes(StandardCharsets.UTF_8);

            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivBytes);
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, paramSpec);
                return new String(cipher.doFinal(Base64.getDecoder().decode(value)), "UTF-8");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return "Error Encrypting Data";
    }
}
