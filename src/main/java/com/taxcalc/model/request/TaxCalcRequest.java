package com.taxcalc.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

public class TaxCalcRequest {

    @NotNull
    private Boolean oldRegime;

    @Positive
    private Long income;

    @Valid
    private Set<Investment> investments;


    public Boolean getOldRegime() {
        return oldRegime;
    }

    public void setOldRegime(Boolean oldRegime) {
        this.oldRegime = oldRegime;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public Set<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }
}
