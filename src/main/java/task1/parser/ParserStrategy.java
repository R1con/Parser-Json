package task1.parser;

import task1.dto.IpDto;

import java.io.IOException;

public interface ParserStrategy {
    IpDto parseJson() throws IOException;
}
