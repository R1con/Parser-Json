package task1.parser;

import com.google.gson.stream.JsonReader;
import task1.dto.IpDto;
import task1.strategy.ParserStrategy;
import java.io.*;

public class FileParser implements ParserStrategy {
    private final String PATH_JSON = "C:\\Users\\igorp\\Desktop\\tst.txt";

    @Override
    public IpDto parseJson() throws IOException {
        JsonReader reader = new JsonReader(new FileReader(PATH_JSON));

        reader.beginObject();
        String ip = null;
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("ip"))
                ip = reader.nextString();
        }
        reader.endObject();

        return new IpDto(ip);
    }
}
