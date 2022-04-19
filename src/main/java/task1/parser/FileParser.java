package task1.parser;

import com.google.gson.stream.JsonReader;
import task1.dto.IpDto;
import task1.strategy.ParserStrategy;
import java.io.*;

public class FileParser implements ParserStrategy {
    private String ip;

    @Override
    public IpDto parseJson(String path) throws IOException {
        JsonReader reader = new JsonReader(new FileReader(path));

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("ip"))
                ip = reader.nextString();
        }
        reader.endObject();

        return new IpDto(ip);
    }
}
