package task1;

import task1.dto.IpDto;
import task1.parser.FileParser;
import task1.parser.JsonParser;
import task1.strategy.ParserStrategy;
import task1.writer.FileWriter;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final FileWriter FILE_WRITER = new FileWriter();
    private static ParserStrategy parserStrategy;
    private static IpDto ipDto;



    public static void main(String[] args) throws IOException {

        if (args.length != 0) {
            if (args[0].equals(TypeOfDataStorage.URL.getType()))
                parserStrategy = new JsonParser();
            else if (args[0].equals(TypeOfDataStorage.FILE.getType()))
                parserStrategy = new FileParser();
        } else {
            TypeOfDataStorage[] type = TypeOfDataStorage.values();
            throw new RuntimeException("Type of: " + Arrays.toString(type));
        }

        ipDto = parserStrategy.parseJson();
        FILE_WRITER.writeToFile(ipDto.getIp());
    }
}

enum TypeOfDataStorage {
    URL("url"),
    FILE("file");

    private final String type;

    TypeOfDataStorage(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
