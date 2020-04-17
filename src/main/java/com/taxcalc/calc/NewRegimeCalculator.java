package com.taxcalc.calc;

import com.taxcalc.model.model.SlabRate;
import com.taxcalc.util.SlabRateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class NewRegimeCalculator {


    private static List<SlabRate> slabRates;

    static {
        slabRates = Arrays.asList(
                SlabRateUtil.createSlab(0L, 2_50_000L, 0),
                SlabRateUtil.createSlab(2_50_000L, 5_00_000L, 5),
                SlabRateUtil.createSlab(5_00_000L, 7_50_000L, 10),
                SlabRateUtil.createSlab(7_50_000L, 10_00_000L, 15),
                SlabRateUtil.createSlab(10_00_000L, 12_50_000L, 20),
                SlabRateUtil.createSlab(12_50_000L, 15_00_000L, 25),
                SlabRateUtil.createSlab(15_00_000L, Long.MAX_VALUE, 30));
    }

    public Long taxableIncome(Long income, Long exemptions) {
        return income;
    }

    public List<SlabRate> getSlabRates() {
        return slabRates;
    }
}
