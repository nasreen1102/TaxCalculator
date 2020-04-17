package com.taxcalc.model.request;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class TaxCalcRequest {

    @Positive
    private Long age;

    @Positive
    private Long income;

    @PositiveOrZero
    private Long taxExemptionAmount;

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public Long getTaxExemptionAmount() {
        return taxExemptionAmount;
    }

    public void setTaxExemptionAmount(Long taxExemptionAmount) {
        this.taxExemptionAmount = taxExemptionAmount;
    }
}
