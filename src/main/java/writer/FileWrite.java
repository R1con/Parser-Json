package writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWrite {

    public void writeJsonObjectToFile(String path, String message) {

        try (BufferedWriter writerFile = Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8)) {
            writerFile.write(message);
            System.out.println("File wrote in " + path);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
