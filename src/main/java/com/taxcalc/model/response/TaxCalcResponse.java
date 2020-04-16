package com.taxcalc.model.response;

public class TaxCalcResponse {

    private Long totalIncome;
    private Long totalExemptionAmount;
    private Long taxableIncome;
    private Long taxToBePaid;

    public Long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Long getTotalExemptionAmount() {
        return totalExemptionAmount;
    }

    public void setTotalExemptionAmount(Long totalExemptionAmount) {
        this.totalExemptionAmount = totalExemptionAmount;
    }

    public Long getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(Long taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public Long getTaxToBePaid() {
        return taxToBePaid;
    }

    public void setTaxToBePaid(Long taxToBePaid) {
        this.taxToBePaid = taxToBePaid;
    }

    @Override
    public String toString() {
        return "TaxCalcResponse{" +
                "totalIncome=" + totalIncome +
                ", totalExemptionAmount=" + totalExemptionAmount +
                ", taxableIncome=" + taxableIncome +
                ", taxToBePaid=" + taxToBePaid +
                '}';
    }
}
