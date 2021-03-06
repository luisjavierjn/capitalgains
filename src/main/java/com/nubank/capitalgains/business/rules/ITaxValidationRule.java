package com.nubank.capitalgains.business.rules;

import com.nubank.capitalgains.model.Simulation;
import com.nubank.capitalgains.model.State;

public interface ITaxValidationRule {

    String Execute(State state, Simulation simulation);

    boolean IsValid(State state, String operationType);
}
