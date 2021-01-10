package com.tp.notification.service;

import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Service
public class Unzipper {

    void unpzip(Path pathToZipFile, Path dirToUnzip) throws IOException {
        int BUFFER = 4096;
        try (ZipFile xlsxFile = new ZipFile(pathToZipFile.toFile())) {
            Enumeration<? extends ZipEntry> zipEntries = xlsxFile.entries();
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = zipEntries.nextElement();
                if (!zipEntry.isDirectory() && ((zipEntry.getName().matches("(.*)sheet(\\d*).xml$")) || (zipEntry.getName().matches("(.*)sharedStrings.xml$")))) {
                    String zipEntryName = zipEntry.getName();
                    int index = zipEntry.getName().lastIndexOf("/");
                    Path path = dirToUnzip.resolve(index == -1 ? zipEntryName : zipEntryName.substring(index + 1));
                    File file = Files.createFile(path).toFile();
                    try (BufferedInputStream bis = new BufferedInputStream(xlsxFile.getInputStream(zipEntry));
                         FileOutputStream fos = new FileOutputStream(file);
                         BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER)){
                        int numOfBytes;
                        byte data[] = new byte[BUFFER];
                        while ((numOfBytes = bis.read(data, 0, BUFFER)) != -1) {
                            bos.write(data, 0, numOfBytes);
                        }
                    }
                }
            }
        }
    }
}
