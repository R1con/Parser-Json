import Parser.ParserJson;
import dto.IpDto;
import writer.FileWrite;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ParserJson parser = new ParserJson();
        FileWrite fileWrite = new FileWrite();

        String url = "https://api.ipify.org/?format=json";
        String path = "C:\\Users\\igorp\\Desktop\\ip-info.txt";

        IpDto ipDto = parser.parseFromUrlToJsonObject(url);
        fileWrite.writeJsonObjectToFile(path, ipDto.getIp());
    }
}
