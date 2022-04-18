import parser.FileParser;
import parser.JsonParser;
import dto.IpDto;
import writer.FileWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter();
        JsonParser Jsonparser = new JsonParser();
        FileParser fileParser = new FileParser();

        final String URL = "https://api.ipify.org/?format=json";
        final String PATH_JSON = "C:\\Users\\igorp\\Desktop\\tst.txt";
        final String PATH_FILE = "C:\\Users\\igorp\\Desktop\\ip-info.txt";

        IpDto ipDto = fileParser.parseJson(PATH_JSON);
        fileWriter.writeToFile(PATH_FILE, ipDto.getIp());


    }
}