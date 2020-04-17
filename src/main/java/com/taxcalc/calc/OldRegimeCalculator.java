package com.taxcalc.calc;

import com.taxcalc.exception.NoSlabRateFoundException;
import com.taxcalc.model.model.Range;
import com.taxcalc.model.model.SlabRate;
import com.taxcalc.util.SlabRateUtil;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OldRegimeCalculator{

    private static Map<Range, List<SlabRate>> ageToSlabRates;

    static {
        Range underAge60 = new Range(0L, 60L);
        Range underAge80 = new Range(60L, 80L);
        Range aboveAge80 = new Range(80L, Long.MAX_VALUE);

        List<SlabRate> under60SlabRates = Arrays.asList(
                SlabRateUtil.createSlab(0L, 2_50_000L, 0),
                SlabRateUtil.createSlab(2_50_000L, 5_00_000L, 5),
                SlabRateUtil.createSlab(5_00_000L, 10_00_000L, 20),
                SlabRateUtil.createSlab(10_00_000L, Long.MAX_VALUE, 30));

        List<SlabRate> under80SlabRates = Arrays.asList(
                SlabRateUtil.createSlab(0L, 3_00_000L, 0),
                SlabRateUtil.createSlab(3_00_000L, 5_00_000L, 5),
                SlabRateUtil.createSlab(5_00_000L, 10_00_000L, 20),
                SlabRateUtil.createSlab(10_00_000L, Long.MAX_VALUE, 30));

        List<SlabRate> above80SlabRates = Arrays.asList(
                SlabRateUtil.createSlab(0L, 5_00_000L, 0),
                SlabRateUtil.createSlab(5_00_000L, 10_00_000L, 20),
                SlabRateUtil.createSlab(10_00_000L, Long.MAX_VALUE, 30));


        ageToSlabRates = new HashMap<>();
        ageToSlabRates.put(underAge60,under60SlabRates);
        ageToSlabRates.put(underAge80,under80SlabRates);
        ageToSlabRates.put(aboveAge80,above80SlabRates);
    }

    public Long taxableIncome(Long income, Long exemptions) {
        return income - exemptions;
    }

    public List<SlabRate> getSlabRates(final Long age) throws NoSlabRateFoundException {
        return ageToSlabRates.entrySet().stream().filter(e -> e.getKey().between(age))
                .findFirst().map(Map.Entry::getValue).orElseThrow(NoSlabRateFoundException::new);
    }

}
