import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class ParserJson {
    private static IP ip = new IP();

    public static void main(String[] args) throws IOException {
        String url = "https://api.ipify.org/?format=json";
        String path = "C:\\Users\\igorp\\Desktop\\ip-info.txt";

        parseFromUrl(url);
        writeJsonObjectToFile(path, ip.getIp());
    }

    public static void parseFromUrl(String url) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Document document = Jsoup.connect(url).ignoreContentType(true).get();
        Elements elements = document.select("body");
        String stringJson = elements.text();

        ip = gson.fromJson(stringJson, IP.class);
    }

    public static void writeJsonObjectToFile(String path, Object obj) {
        try (BufferedWriter writerFile = Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8)) {
            writerFile.write(String.valueOf(obj));
            System.out.println("File wrote in " + path);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
