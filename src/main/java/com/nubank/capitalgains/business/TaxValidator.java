package com.nubank.capitalgains.business;

import com.nubank.capitalgains.model.State;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaxValidator {
    private final State state;
    private final List<String> taxResult = new ArrayList<>();;
    private final List<ITaxValidationRule> rules = new ArrayList<>();

    public TaxValidator(State state) {
        this.state = state;

        rules.add(new BuyValidationRule());
        rules.add(new SellValidationRule());
        rules.add(new SellWithLossesValidationRule());
    }

    public void resetState() {
        state.reset();
        taxResult.clear();
    }

    public void validate(String info) {
        rules.stream()
                .filter(r -> r.IsValid(state,info))
                .forEach(r -> taxResult.add(r.Execute(info)));
    }

    public String getTaxResult() {
        return taxResult.stream()
                .collect(Collectors.joining(",","[","]"));
    }
}
