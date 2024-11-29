package com.project.storeSystem.Util;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SystemUtil {

    public static void downloadFile(String folder, String fileName, HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getServletContext();
        String serverPath = context.getRealPath("/"); // Get the absolute path to the web app directory

        folder = "resources/" + folder;
        File file = new File(serverPath + folder + "/" + fileName);
        serveFile(response, file, folder, fileName);
    }

    private static void serveFile(HttpServletResponse response, File file, String folder, String fileName) {
        try {
            if (!file.exists()) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
                return;
            }

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

            try (FileInputStream fin = new FileInputStream(file);
                 ServletOutputStream os = response.getOutputStream()) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = fin.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }

            if (folder.endsWith("download")) {
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
