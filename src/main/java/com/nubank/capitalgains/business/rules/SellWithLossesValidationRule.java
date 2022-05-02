package com.nubank.capitalgains.business.rules;

import com.nubank.capitalgains.model.OperationType;
import com.nubank.capitalgains.model.Simulation;
import com.nubank.capitalgains.model.State;

public class SellWithLossesValidationRule implements ITaxValidationRule {

    @Override
    public String Execute(State state, Simulation simulation) {
        return null;
    }

    @Override
    public boolean IsValid(State state, String operationType) {
        return false;
    }
}
