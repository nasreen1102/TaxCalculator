package com.taxcalc.calc;

import org.springframework.stereotype.Component;

@Component
public class CalcFactory {

    public Calculator createCalculator(boolean isOldRegime){

        if (isOldRegime) {
            return new OldRegimeCalculator();
        } else {
            return new NewRegimeCalculator();
        }
    }

}
