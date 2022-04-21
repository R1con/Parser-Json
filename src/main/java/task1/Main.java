package task1;

import task1.dto.IpDto;
import task1.writer.FileWriter;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final FileWriter FILE_WRITER = new FileWriter();
    private static IpDto ipDto = new IpDto();

    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            ipDto = TypeOfDataStorage.getTypeByArgument(args[0]).getStrategy().parseJson();
            FILE_WRITER.writeToFile(ipDto.getIp());
        } else {
            throw new RuntimeException("Type of: " + Arrays.toString(TypeOfDataStorage.values()));
        }
    }
}
