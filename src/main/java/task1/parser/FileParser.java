package task1.parser;

import com.google.gson.Gson;
import task1.dto.IpDto;
import task1.strategy.ParserStrategy;
import java.io.*;

public class FileParser implements ParserStrategy {
    private final String PATH_JSON = "C:\\Users\\igorp\\Desktop\\tst.txt";
    private final Gson GSON = new Gson();
    @Override
    public IpDto parseJson() throws IOException {
        File file = new File(PATH_JSON);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        return GSON.fromJson(bufferedReader, IpDto.class);
    }
}
