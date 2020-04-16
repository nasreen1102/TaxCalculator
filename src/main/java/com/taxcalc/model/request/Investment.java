package com.taxcalc.model.request;

import java.util.Set;

public class Investment {

    private int id;
    private String sectionName;
    private String description;
    private Set<InvestmentType> investmentTypeSet;
    private Long permissibleLimit;
}
