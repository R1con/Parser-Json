package task1.parser;

import com.google.gson.*;
import task1.dto.IpDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;
import task1.strategy.ParserStrategy;

import java.io.*;

public class JsonParser implements ParserStrategy {
    private final static Gson GSON = new GsonBuilder().create();
    private final String URL = "https://api.ipify.org/?format=json";

    @Override
    public IpDto parseJson() throws IOException {
        Document document = Jsoup.connect(URL).ignoreContentType(true).get();
        Elements elements = document.select("body");

        return GSON.fromJson(elements.text(), IpDto.class);
    }
}
