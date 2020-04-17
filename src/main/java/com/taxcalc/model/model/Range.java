package com.taxcalc.model.model;

import com.taxcalc.exception.InvalidRangeException;

import javax.validation.constraints.NotNull;

public class Range { //todo: can make it generic that accepts only numbers <? extends Number>

    private final Long startExclusive;
    private final Long endInclusive;

    public Range(@NotNull Long startExclusive, @NotNull Long endInclusive) throws InvalidRangeException {
        if (startExclusive.compareTo(endInclusive) >= 0 ) {
            throw new InvalidRangeException("endInclusive value should be greater than startExclusive");
        }
        this.startExclusive = startExclusive;
        this.endInclusive = endInclusive;
    }

    public boolean between(Long number) {
        return number != null && number > startExclusive && number <= endInclusive;
    }

    public long difference(){
        return endInclusive - startExclusive;
    }

    @Override
    public String toString() {
        return "Range{" +
                "startExclusive=" + startExclusive +
                ", endInclusive=" + endInclusive +
                '}';
    }
}
