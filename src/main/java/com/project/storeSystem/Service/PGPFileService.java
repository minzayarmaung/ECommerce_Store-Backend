package com.project.storeSystem.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface PGPFileService {
    Object decryptFile(MultipartFile file, String privateKeyPath, String passphrase) throws Exception;

}
