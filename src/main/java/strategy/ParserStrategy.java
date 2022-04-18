package strategy;

import dto.IpDto;

import java.io.IOException;

public interface ParserStrategy {
    public IpDto parseJson(String path) throws IOException;
}
