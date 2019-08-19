package TextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractFile03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        String fileName = path.substring(path.lastIndexOf('\\') + 1, path.indexOf('.'));
        String extension = path.substring(path.lastIndexOf('.') + 1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);

    }
}
