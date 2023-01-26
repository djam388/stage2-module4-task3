package com.mjc.stage2.entity;

public class SymbolLeaf extends AbstractTextComponent{

    private char value;

    public SymbolLeaf(TextComponentType componentType) {
        super(componentType);
    }


    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String operation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {

    }

    @Override
    public void remove(AbstractTextComponent textComponent) {

    }

    @Override
    public int getSize() {
        return 1;
    }


    // Write your code here!
}
