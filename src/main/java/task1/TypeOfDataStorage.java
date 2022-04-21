package task1;

import task1.parser.FileParser;
import task1.parser.JsonParser;
import task1.strategy.ParserStrategy;

import java.util.Arrays;

public enum TypeOfDataStorage {
    URL("url", new JsonParser()),
    FILE("file", new FileParser());

    private final String TYPE_STORAGE;
    private final ParserStrategy STRATEGY;

    public ParserStrategy getSTRATEGY() {
        return STRATEGY;
    }

    TypeOfDataStorage(String typeStorage, ParserStrategy strategy) {
        this.TYPE_STORAGE = typeStorage;
        this.STRATEGY = strategy;
    }

    public static TypeOfDataStorage getTypeByArgument(String storage) {
        for (TypeOfDataStorage type : TypeOfDataStorage.values()) {
            if (type.TYPE_STORAGE.equals(storage))
                return type;
        }

        throw new RuntimeException("Type of data storage not found: " + Arrays.toString(TypeOfDataStorage.values()));
    }
}
