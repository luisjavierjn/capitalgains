package com.nubank.capitalgains.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class State implements Cloneable {
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

    @Override
    public State clone() {
        try {
            State clone = (State) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.currentQuantity = new BigInteger(this.currentQuantity.toString());
            clone.currentPrice = new BigDecimal(this.currentPrice.toString());
            clone.deductibleLoss = new BigDecimal(this.deductibleLoss.toString());
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
