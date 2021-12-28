package demoTestStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestFileStream {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("src/demoTestStream/temp.dat");
            for (int i = 0; i < 10; i++) {
                outputStream.write(i);
            }
            try (FileInputStream inputStream = new FileInputStream("src/demoTestStream/temp.dat");) {
                int value;
                while ((value = inputStream.read()) != -1) {
                    System.out.println(value + " ");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
