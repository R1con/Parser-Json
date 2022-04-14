import parser.ParserJson;
import dto.IpDto;
import writer.FileWrite;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParserJson parser = new ParserJson();
        FileWrite fileWrite = new FileWrite();

        final String URL = "https://api.ipify.org/?format=json";
        final String PATH = "C:\\Users\\igorp\\Desktop\\ip-info.txt";


        IpDto ipDto = parser.parseFromUrlToJsonObject(URL);
        fileWrite.writeJsonObjectToFile(PATH, ipDto.getIp());
    }
}
