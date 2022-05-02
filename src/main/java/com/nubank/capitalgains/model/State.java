package com.nubank.capitalgains.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class State {
    Integer currentQuantity;
    Double currentPrice;
    Double deductibleLoss;

    public void reset() {
        currentQuantity = 0;
        currentPrice = 0.0;
        deductibleLoss = 0.0;
    }

    public Double calcWeightedAvgPrice(Integer newQuantity, Double newPrice) {
        return ((currentQuantity * currentPrice) + (newQuantity * newPrice)) / (currentQuantity + newQuantity);
    }

    public Integer calcCurrentQuantity(Integer newQuantity) {
        return (currentQuantity + newQuantity);
    }

    public Double calcDeductibleLoss(Double newLoss) {
        return (deductibleLoss + newLoss);
    }
}
