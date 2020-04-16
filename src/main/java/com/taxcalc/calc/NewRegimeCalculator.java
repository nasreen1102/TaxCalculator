package com.taxcalc.calc;

import com.taxcalc.model.model.Range;
import com.taxcalc.model.model.SlabRate;
import com.taxcalc.util.SlabRateUtil;

import java.util.Arrays;
import java.util.List;


public class NewRegimeCalculator implements Calculator {

    private List<SlabRate> slabRates = Arrays.asList(
            SlabRateUtil.createSlab(0L, 2_50_000L, 0),
            SlabRateUtil.createSlab(2_50_000L, 5_00_000L, 5),
            SlabRateUtil.createSlab(5_00_000L, 7_50_000L, 10),
            SlabRateUtil.createSlab(7_50_000L, 10_00_000L, 15),
            SlabRateUtil.createSlab(10_00_000L, 12_50_000L, 20),
            SlabRateUtil.createSlab(12_50_000L, 15_00_000L, 25),
            SlabRateUtil.createSlab(15_00_000L, Long.MAX_VALUE, 30));

    @Override
    public Long calculate(Long income) {
        Long temp = new Long(income);
        System.out.println("Total income: "+temp);
        Long tax = 0L;
        for (SlabRate slabRate : slabRates) {
            Range range = slabRate.getRange();
            Integer percent = slabRate.getPercent();
            long currentTaxedAmount;
            long rangeDifference = range.difference();
            if (temp >= rangeDifference) {
                currentTaxedAmount = rangeDifference;
            } else {
                currentTaxedAmount = temp;
            }
            tax += percent==0?0:currentTaxedAmount*percent/100;
            temp -= currentTaxedAmount;
            System.out.println(slabRate+" has a tax: "+tax);
        }
        return tax;
    }
}
