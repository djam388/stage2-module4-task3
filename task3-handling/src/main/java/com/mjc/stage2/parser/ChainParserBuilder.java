package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        if (parsers.size() > 0 && abstractTextParser != null) {
            parsers.get(parsers.size() - 1).setNextParser(abstractTextParser);
        }
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        // Write your code here!
        return parsers.get(0);
    }
}
