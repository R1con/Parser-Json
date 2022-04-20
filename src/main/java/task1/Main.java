package task1;

import task1.dto.IpDto;
import task1.parser.FileParser;
import task1.parser.JsonParser;
import task1.strategy.ParserStrategy;
import task1.writer.FileWriter;

import java.io.IOException;

public class Main {
    private static ParserStrategy parserStrategy = null;
    private static IpDto ipDto = null;

    private static final FileWriter FILE_WRITER = new FileWriter();

    public static void main(String[] args) throws IOException {
        final String ARGUMENT_URL = "url";
        final String ARGUMENT_FILE = "file";

        if (args[0].equals(ARGUMENT_URL)) {
            parserStrategy = new JsonParser();
            ChoosingStrategy(parserStrategy);
        } else if (args[0].equals(ARGUMENT_FILE)) {
            parserStrategy = new FileParser();
            ChoosingStrategy(parserStrategy);
        } else {
            System.out.println("Incorrect input. Input url or file.");
        }

    }

    private static void ChoosingStrategy(ParserStrategy parserStrategy) throws IOException {
        ipDto = parserStrategy.parseJson();
        FILE_WRITER.writeToFile(ipDto.getIp());
    }
}