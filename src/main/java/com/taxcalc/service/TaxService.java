package com.taxcalc.service;

import com.taxcalc.calc.NewRegimeCalculator;
import com.taxcalc.calc.OldRegimeCalculator;
import com.taxcalc.exception.NoSlabRateFoundException;
import com.taxcalc.model.model.SlabRate;
import com.taxcalc.model.request.TaxCalcRequest;
import com.taxcalc.model.response.TaxCalcResponse;
import com.taxcalc.util.SlabRateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService {

    @Autowired
    private SlabRateUtil slabRateUtil;

    @Autowired
    private OldRegimeCalculator oldRegimeCalculator;

    @Autowired
    private NewRegimeCalculator newRegimeCalculator;

    public TaxCalcResponse calculate(TaxCalcRequest taxCalcRequest) {

        if(taxCalcRequest.getIncome() <= 5_00_000L){
            return new TaxCalcResponse(0L, 0L, "No tax for income below 5lakhs under Rebate section 27/A"); //no tax due to tax rebate
        }

        TaxCalcResponse response = new TaxCalcResponse();
        try {
            List<SlabRate> slabRates = oldRegimeCalculator.getSlabRates(taxCalcRequest.getAge());
            Long taxableIncome = oldRegimeCalculator.taxableIncome(taxCalcRequest.getIncome(), taxCalcRequest.getTaxExemptionAmount());
            Long oldRegimeTax = slabRateUtil.calculateTax(taxableIncome, slabRates);
            response.setOldRegimeTax(oldRegimeTax);
        } catch (NoSlabRateFoundException e) {
            System.out.println("Error while calculating old regime tax");
            e.printStackTrace();
        }

        Long newRegimeTax = slabRateUtil.calculateTax(taxCalcRequest.getIncome(), newRegimeCalculator.getSlabRates());
        response.setNewRegimeTax(newRegimeTax);
        setSuggestion(response);
        return response;
    }

    private void setSuggestion(TaxCalcResponse response) {
        Long oldRegimeTax = response.getOldRegimeTax();
        Long newRegimeTax = response.getNewRegimeTax();
        if(oldRegimeTax!=null && newRegimeTax!=null){
            String suggestion;
            int compare = oldRegimeTax.compareTo(newRegimeTax);
            if(compare > 0 ) {
                suggestion = "New regime tax is beneficial at a cost of "+(oldRegimeTax - newRegimeTax);
            } else if(compare < 0) {
                suggestion  = "New regime tax is beneficial at a cost of "+(newRegimeTax - oldRegimeTax);
            } else {
                suggestion = " Both the tax regimes are equally beneficial";
            }
            response.setSuggestion(suggestion);
        }
    }

}