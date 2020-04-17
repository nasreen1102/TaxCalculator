package com.taxcalc.model.response;

public class TaxCalcResponse {

    private Long oldRegimeTax;
    private Long newRegimeTax;
    private String suggestion;

    public TaxCalcResponse() {
    }

    public TaxCalcResponse(Long oldRegimeTax, Long newRegimeTax, String suggestion) {
        this.oldRegimeTax = oldRegimeTax;
        this.newRegimeTax = newRegimeTax;
        this.suggestion = suggestion;
    }

    public Long getOldRegimeTax() {
        return oldRegimeTax;
    }

    public void setOldRegimeTax(Long oldRegimeTax) {
        this.oldRegimeTax = oldRegimeTax;
    }

    public Long getNewRegimeTax() {
        return newRegimeTax;
    }

    public void setNewRegimeTax(Long newRegimeTax) {
        this.newRegimeTax = newRegimeTax;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "TaxCalcResponse{" +
                "oldRegimeTax=" + oldRegimeTax +
                ", newRegimeTax=" + newRegimeTax +
                ", suggestion='" + suggestion + '\'' +
                '}';
    }
}
