package com.project.storeSystem.Controller;

import com.project.storeSystem.Service.PGPFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.project.storeSystem.ServiceImpl.pgpFileServiceImpl.logger;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {

    @Autowired
    private PGPFileService pgpFileService;

    @PostMapping("/decrypt")
    public ResponseEntity<?> decryptFile(@RequestParam("file")MultipartFile file,
                                         @RequestParam("privateKeyPath") String privateKeyPath,
                                         @RequestParam("passphrase") String passphrase) {

        try {
            Object jsonData = pgpFileService.decryptFile(file, privateKeyPath, passphrase);
            return ResponseEntity.status(200).body("Decrypted Data : " + jsonData);
        } catch (JsonParseException e) {
            logger.error("JSON parsing failed", e);
            return ResponseEntity.status(400).body("Invalid JSON format in decrypted content");
        } catch (Exception e) {
            logger.error("Decryption failed", e);
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }

    }
}
