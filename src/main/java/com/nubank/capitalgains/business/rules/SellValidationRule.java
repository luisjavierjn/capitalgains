package com.nubank.capitalgains.business.rules;

import com.nubank.capitalgains.model.OperationType;
import com.nubank.capitalgains.model.Simulation;
import com.nubank.capitalgains.model.State;

public class SellValidationRule implements ITaxValidationRule {

    @Override
    public String Execute(State state, Simulation simulation) {
        Double cost = simulation.getQuantity() * state.getCurrentPrice();
        Double sell = simulation.getQuantity() * simulation.getUnitcost();
        state.setCurrentQuantity(state.calcCurrentQuantity(-simulation.getQuantity()));
        state.setDeductibleLoss(state.calcDeductibleLoss(Math.max(cost - sell, 0)));
        double profit = sell > cost ? 0.2 * (sell - cost) : 0.0;
        return "{\"tax\":" + profit + "}";
    }

    @Override
    public boolean IsValid(State state, String operationType) {
        return (OperationType.fromValue(operationType) == OperationType.SELL) &&
                state.getDeductibleLoss() == 0;
    }
}
