package com.nubank.capitalgains.business;

import com.nubank.capitalgains.model.State;

public class SellWithLossesValidationRule implements ITaxValidationRule {

    @Override
    public String Execute(String info) {
        return null;
    }

    @Override
    public boolean IsValid(State state, String info) {
        return false;
    }
}
