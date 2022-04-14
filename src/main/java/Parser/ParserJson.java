package Parser;

import com.google.gson.*;
import dto.IpDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

import java.io.*;

public class ParserJson {
    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.create();

    public IpDto parseFromUrlToJsonObject(String url) throws IOException {
        Document document = Jsoup.connect(url).ignoreContentType(true).get();
        Elements elements = document.select("body");

        return gson.fromJson(elements.text(), IpDto.class);
    }
}
