package task1.strategy;

import task1.dto.IpDto;

import java.io.IOException;

public interface ParserStrategy {
    IpDto parseJson() throws IOException;
}
