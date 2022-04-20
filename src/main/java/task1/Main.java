package task1;

import task1.dto.IpDto;
import task1.parser.FileParser;
import task1.parser.JsonParser;
import task1.strategy.ParserStrategy;
import task1.writer.FileWriter;

import java.io.IOException;

public class Main {
    private static final FileWriter FILE_WRITER = new FileWriter();
    private static ParserStrategy parserStrategy;
    private static IpDto ipDto;

    public static void main(String[] args) throws IOException {
        final String ARGUMENT_URL = TypeOfDataStorage.URL.getType();
        final String ARGUMENT_FILE = TypeOfDataStorage.FILE.getType();

        if (args.length != 0) {
            if (args[0].equals(ARGUMENT_URL)) {
                parserStrategy = new JsonParser();
            } else if (args[0].equals(ARGUMENT_FILE)) {
                parserStrategy = new FileParser();
            } else {
                System.out.println("Incorrect input. Input url or file.");
            }
        } else {
            System.out.println("Input argument url or file.");
        }

        try {
            ipDto = parserStrategy.parseJson();
            FILE_WRITER.writeToFile(ipDto.getIp());
        } catch (NullPointerException e) {
            e.getMessage();
        }


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