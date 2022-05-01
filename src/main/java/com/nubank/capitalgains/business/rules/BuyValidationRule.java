package com.nubank.capitalgains.business.rules;

import com.nubank.capitalgains.model.Simulation;
import com.nubank.capitalgains.model.State;

public class BuyValidationRule implements ITaxValidationRule {

    @Override
    public String Execute(Simulation simulation) {
        return "{\"tax\":0.00}";
    }

    @Override
    public boolean IsValid(State state, String operationType) {
        return true;
    }
}
