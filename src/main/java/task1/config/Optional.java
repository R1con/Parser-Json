package task1.config;

import task1.dto.IpDto;
import task1.parser.FileParser;
import task1.parser.JsonParser;
import task1.strategy.ParserStrategy;
import task1.writer.FileWriter;

import java.io.IOException;
import java.util.Scanner;



public class Optional {
    private  final FileParser FILE_PARSER = new FileParser();
    private  final JsonParser JSON_PARSER = new JsonParser();
    private  final FileWriter FILE_WRITER = new FileWriter();

    private final String URL="https://api.ipify.org/?format=json";
    private final String PATH_FILE="C:\\Users\\igorp\\Desktop\\ip-info.txt";
    private final String PATH_JSON="C:\\Users\\igorp\\Desktop\\tst.txt";

    public  void configure()throws IOException {
        System.out.print("1 - записи из файла" + " 2 - запись из URL: ");

        Scanner in = new Scanner(System.in);
        int question = in.nextInt();

        if (question == 1) {
            IpDto ipDto = FILE_PARSER.parseJson(PATH_JSON);
            FILE_WRITER.writeToFile(PATH_FILE, ipDto.getIp());
        } else if (question == 2) {
            IpDto ipDto = JSON_PARSER.parseJson(URL);
            FILE_WRITER.writeToFile(PATH_FILE, ipDto.getIp());
        }
    }
}
