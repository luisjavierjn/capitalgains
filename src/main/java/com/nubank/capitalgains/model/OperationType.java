package com.nubank.capitalgains.model;

public enum OperationType {
    BUY("buy"),
    SELL("sell");

    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    public static OperationType fromValue(String text) {
        for (OperationType b : OperationType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
