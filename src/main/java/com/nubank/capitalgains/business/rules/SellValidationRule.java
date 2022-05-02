package com.nubank.capitalgains.business.rules;

import com.nubank.capitalgains.model.OperationType;
import com.nubank.capitalgains.model.Simulation;
import com.nubank.capitalgains.model.State;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SellValidationRule implements ITaxValidationRule {
    private static final String ZERO = "0.0";
    private static final String PERC = "0.2";

    @Override
    public String Execute(State state, Simulation simulation) {
        BigDecimal cost = state.getCurrentPrice().multiply(new BigDecimal(simulation.getQuantity()));
        BigDecimal sell = simulation.getUnitcost().multiply(new BigDecimal(simulation.getQuantity()));
        state.setCurrentQuantity(state.calcCurrentQuantity(simulation.getQuantity().negate()));
        state.setDeductibleLoss(state.calcDeductibleLoss(cost.subtract(sell).max(new BigDecimal(ZERO))));
        BigDecimal taxValue = sell.compareTo(cost) > 0 ? sell.subtract(cost).multiply(new BigDecimal(PERC)) : new BigDecimal(ZERO);
        return "{\"tax\":" + taxValue.setScale(2, RoundingMode.HALF_UP) + "}";
    }

    @Override
    public boolean IsValid(State state, String operationType) {
        return (OperationType.fromValue(operationType) == OperationType.SELL) &&
                state.getDeductibleLoss().compareTo(new BigDecimal(ZERO)) == 0;
    }
}
