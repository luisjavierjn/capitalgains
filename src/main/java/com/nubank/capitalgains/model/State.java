package com.nubank.capitalgains.model;

public class State {
    double averagePrice;
    double deductibleLoss;

    public void reset() {
        averagePrice = 0;
        deductibleLoss = 0;
    }
}
