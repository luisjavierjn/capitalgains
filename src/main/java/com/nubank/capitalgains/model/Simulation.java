package com.nubank.capitalgains.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Simulation {
    String operation;
    BigDecimal unitcost;
    BigInteger quantity;
}
