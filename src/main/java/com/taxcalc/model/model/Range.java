package com.taxcalc.model.model;

import javax.validation.constraints.NotNull;

public class Range {

    private Long startExclusive;
    private Long endInclusive;

    public Range(@NotNull Long startExclusive, @NotNull Long endInclusive) {
        if (startExclusive.compareTo(endInclusive) >= 0 ) {
            throw new RuntimeException("endInclusive value should be greater than startExclusive");
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
