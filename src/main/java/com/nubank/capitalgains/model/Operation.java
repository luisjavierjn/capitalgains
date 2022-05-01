package com.nubank.capitalgains.model;

public enum Operation {
    BUY("buy"),
    SELL("sell");

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Operation fromValue(String text) {
        for (Operation b : Operation.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
