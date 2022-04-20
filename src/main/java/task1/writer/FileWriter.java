package task1.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {
    private final String PATH_FILE = "C:\\Users\\igorp\\Desktop\\ip-info.txt";

    public void writeToFile(String message) {
        try (BufferedWriter writerFile = Files.newBufferedWriter(Path.of(PATH_FILE), StandardCharsets.UTF_8)) {
            writerFile.write(message);
            System.out.println("File wrote in " + PATH_FILE);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
