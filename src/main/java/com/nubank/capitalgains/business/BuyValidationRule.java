package com.nubank.capitalgains.business;

import com.nubank.capitalgains.model.State;

public class BuyValidationRule implements ITaxValidationRule {

    @Override
    public String Execute(String info) {
        return "{\"tax\":0.00}";
    }

    @Override
    public boolean IsValid(State state, String info) {
        return true;
    }
}
