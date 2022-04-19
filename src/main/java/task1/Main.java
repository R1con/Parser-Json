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

        final String URL = "https://api.ipify.org/?format=json";
        final String PATH_JSON = "C:\\Users\\igorp\\Desktop\\tst.txt";
        final String PATH_FILE = "C:\\Users\\igorp\\Desktop\\ip-info.txt";

        if (args[0].equals("url")) {
            parserStrategy = new JsonParser();
            ipDto = parserStrategy.parseJson(URL);
        } else if (args[0].equals("file")) {
            parserStrategy = new FileParser();
            ipDto = parserStrategy.parseJson(PATH_JSON);
        } else {
            System.out.println("Incorrect input. Input url or file.");
        }

        try {
            FILE_WRITER.writeToFile(PATH_FILE, ipDto.getIp());
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
}