package com.thucHanh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyFiles {
    private static void copyFileUsingJava7File(File source, File dest) {
        try {
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException io) {
            System.err.println(io.getMessage());
        }

    }

    private static void copyFilesUsingStream(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source); OutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.println("Enter destination file:");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        copyFileUsingJava7File(sourceFile, destFile);
        //copyFileUsingStream(sourceFile, destFile);
        System.out.println("Copy completed");

    }
}
