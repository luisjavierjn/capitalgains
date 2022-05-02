package com.nubank.capitalgains.business.rules;

import com.nubank.capitalgains.model.OperationType;
import com.nubank.capitalgains.model.Simulation;
import com.nubank.capitalgains.model.State;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SellWithLossesValidationRule implements ITaxValidationRule {
    private static final String ZERO = "0.0";
    private static final String PERC = "0.2";
    private static final BigDecimal LIMIT = new BigDecimal("20000");

    @Override
    public String Execute(State state, Simulation simulation) {
        BigDecimal cost = state.getCurrentPrice().multiply(new BigDecimal(simulation.getQuantity()));
        BigDecimal sell = simulation.getUnitcost().multiply(new BigDecimal(simulation.getQuantity()));
        state.setCurrentQuantity(state.calcCurrentQuantity(simulation.getQuantity().negate()));

        BigDecimal taxValue = new BigDecimal(ZERO);
        if(sell.compareTo(cost) > 0) {
            if(sell.compareTo(LIMIT) > 0) {
                BigDecimal diff = state.getDeductibleLoss().compareTo(sell.subtract(cost)) > 0 ?
                        sell.subtract(cost) :
                        state.getDeductibleLoss();
                taxValue = sell.subtract(cost).subtract(diff).multiply(new BigDecimal(PERC));
                state.setDeductibleLoss(state.calcDeductibleLoss(diff.negate()));
            }
        } else {
            state.setDeductibleLoss(state.calcDeductibleLoss(cost.subtract(sell)));
        }

        return "{\"tax\":" + taxValue.setScale(2, RoundingMode.HALF_UP) + "}";
    }

    @Override
    public boolean IsValid(State state, String operationType) {
        return (OperationType.fromValue(operationType) == OperationType.SELL) &&
                state.getDeductibleLoss().compareTo(new BigDecimal(ZERO)) > 0;
    }
}
