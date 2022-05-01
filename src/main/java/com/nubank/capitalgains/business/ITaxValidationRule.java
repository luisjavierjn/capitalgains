package com.nubank.capitalgains.business;

import com.nubank.capitalgains.model.State;

public interface ITaxValidationRule {

    String Execute(String info);

    boolean IsValid(State state, String info);
}
