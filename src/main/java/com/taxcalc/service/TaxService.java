package com.taxcalc.service;

import com.taxcalc.calc.CalcFactory;
import com.taxcalc.calc.Calculator;
import com.taxcalc.model.request.TaxCalcRequest;
import com.taxcalc.model.response.TaxCalcResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

    @Autowired
    private CalcFactory calcFactory;

    public TaxCalcResponse calculate(TaxCalcRequest taxCalcRequest) {
        Calculator calculator = calcFactory.createCalculator(taxCalcRequest.getOldRegime());
        Long taxToBePaid = calculator.calculate(taxCalcRequest.getIncome());
        TaxCalcResponse response = new TaxCalcResponse();
        response.setTotalIncome(taxCalcRequest.getIncome());
        response.setTotalExemptionAmount(0L);
        response.setTaxableIncome(taxCalcRequest.getIncome());
        response.setTaxToBePaid(taxToBePaid);
        return response;
    }

}