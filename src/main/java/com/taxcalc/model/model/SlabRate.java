package com.taxcalc.model.model;

public class SlabRate {
    private Range range;
    private int percent;

    public SlabRate(Range range, int percent) {
        this.range = range;
        this.percent = percent;
    }


    public Range getRange() {
        return range;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return "SlabRate{" +
                "range=" + range +
                ", percent=" + percent +
                '}';
    }
}
