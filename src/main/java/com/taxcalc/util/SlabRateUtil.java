package com.taxcalc.util;

import com.taxcalc.model.model.Range;
import com.taxcalc.model.model.SlabRate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SlabRateUtil {

    private static Range createRange(Long lower, Long upper) {
        return new Range(lower, upper);
    }

    public static SlabRate createSlab(Long lower, Long upper, Integer percentage) {
        return new SlabRate(createRange(lower, upper), percentage);
    }

    public Long calculateTax(Long income, List<SlabRate> slabRates) {
        Long temp = new Long(income);
        long tax = 0L;
        for (SlabRate slabRate : slabRates) {
            Range range = slabRate.getRange();
            int percent = slabRate.getPercent();
            long currentTaxedAmount;
            long rangeDifference = range.difference();
            if (temp >= rangeDifference) {
                currentTaxedAmount = rangeDifference;
            } else {
                currentTaxedAmount = temp;
            }
            tax += percent==0?0:currentTaxedAmount*percent/100;
            temp -= currentTaxedAmount;
        }
        return tax;
    }
}
