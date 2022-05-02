package com.nubank.capitalgains.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class State {
    BigInteger currentQuantity;
    BigDecimal currentPrice;
    BigDecimal deductibleLoss;

    public void reset() {
        currentQuantity = new BigInteger("0");
        currentPrice = new BigDecimal("0.0");
        deductibleLoss = new BigDecimal("0.0");
    }

    public BigDecimal calcWeightedAvgPrice(BigInteger newQuantity, BigDecimal newPrice) {
        return currentPrice.multiply(new BigDecimal(currentQuantity))
                .add(newPrice.multiply(new BigDecimal(newQuantity)))
                .divide(new BigDecimal(currentQuantity.add(newQuantity)), 2, RoundingMode.HALF_UP);
    }

    public BigInteger calcCurrentQuantity(BigInteger newQuantity) {
        return currentQuantity.add(newQuantity);
    }

    public BigDecimal calcDeductibleLoss(BigDecimal newLoss) {
        return deductibleLoss.add(newLoss);
    }
}
