package com.entity;

public enum CabTypeEnum {

    CLASS1(1, 20),
    CLASS2(2, 15),
    CLASS3(3, 10),
    CLASS4(4, 5);

    private final int type;
    private final int percent;

    CabTypeEnum(int type, int percent) {
        this.type = type;
        this.percent = percent;
    }

    public int getType() {
        return type;
    }
    public int getPercent() {
        return percent;
    }
}