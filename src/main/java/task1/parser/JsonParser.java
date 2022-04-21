package task1.parser;

import com.google.gson.*;
import task1.dto.IpDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import task1.strategy.ParserStrategy;

import java.io.*;

public class JsonParser implements ParserStrategy {
    private final Gson GSON = new Gson();
    private final String URL = "https://api.ipify.org/?format=json";

    @Override
    public IpDto parseJson() throws IOException {
        Document document = Jsoup.connect(URL).ignoreContentType(true).get();

        return GSON.fromJson(document.text(), IpDto.class);
    }
}
