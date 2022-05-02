package com.nubank.capitalgains.business.rules;

import com.nubank.capitalgains.model.OperationType;
import com.nubank.capitalgains.model.Simulation;
import com.nubank.capitalgains.model.State;

public class BuyValidationRule implements ITaxValidationRule {
    private static final String RESPONSE = "{\"tax\":0.00}";

    @Override
    public String Execute(State state, Simulation simulation) {
        state.setCurrentPrice(state.calcWeightedAvgPrice(simulation.getQuantity(),simulation.getUnitcost()));
        state.setCurrentQuantity(state.calcCurrentQuantity(simulation.getQuantity()));

        return RESPONSE;
    }

    @Override
    public boolean IsValid(State state, String operationType) {
        return OperationType.fromValue(operationType) == OperationType.BUY;
    }
}
