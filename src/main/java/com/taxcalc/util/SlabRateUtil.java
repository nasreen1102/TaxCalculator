package com.taxcalc.util;

import com.taxcalc.model.model.Range;
import com.taxcalc.model.model.SlabRate;

public class SlabRateUtil {

    private static Range createRange(Long lower, Long upper) {
        return new Range(lower, upper);
    }

    public static SlabRate createSlab(Long lower, Long upper, Integer percentage) {
        return new SlabRate(createRange(lower, upper), percentage);
    }

}
