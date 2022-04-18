package parser;

import com.google.gson.*;
import dto.IpDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;
import strategy.ParserStrategy;

import java.io.*;

public class JsonParser implements ParserStrategy {
    private final static Gson gson = new GsonBuilder().create();

    @Override
    public IpDto parseJson(String path) throws IOException {
        Document document = Jsoup.connect(path).ignoreContentType(true).get();
        Elements elements = document.select("body");

        return gson.fromJson(elements.text(), IpDto.class);
    }
}
