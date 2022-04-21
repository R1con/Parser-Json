package task1;

import task1.parser.FileParser;
import task1.parser.JsonParser;
import task1.strategy.ParserStrategy;

import java.util.Arrays;

public enum TypeOfDataStorage {
    URL("url", new JsonParser()),
    FILE("file", new FileParser());

    private String typeStorage;
    private ParserStrategy strategy;

    public ParserStrategy getStrategy() {
        return strategy;
    }

    TypeOfDataStorage(String typeStorage, ParserStrategy strategy) {
        this.typeStorage = typeStorage;
        this.strategy = strategy;
    }

    public static TypeOfDataStorage getTypeByArgument(String storage) {
        for (TypeOfDataStorage type : TypeOfDataStorage.values()) {
            if (type.typeStorage.equals(storage))
                return type;
        }

        throw new RuntimeException("Type of data storage not found: " + Arrays.toString(TypeOfDataStorage.values()));
    }
}
