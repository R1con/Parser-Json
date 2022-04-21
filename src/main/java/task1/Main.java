package task1;

import task1.dto.IpDto;
import task1.writer.FileWriter;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final FileWriter FILE_WRITER = new FileWriter();

    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            IpDto ipDto = TypeOfDataStorage.getTypeByArgument(args[0]).getStrategy().parseJson();
            FILE_WRITER.writeToFile(ipDto.getIp());
        } else {
            throw new RuntimeException("Input argument: " + Arrays.toString(TypeOfDataStorage.values()));
        }
    }
}
