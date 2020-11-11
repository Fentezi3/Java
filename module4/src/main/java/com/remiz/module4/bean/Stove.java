package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Stove extends ElectricDevice implements ICook {
    public Stove() {
    }

    public Stove(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    @Override
    public void cook() {
        System.out.println("I can boil and fry your food.");
    }
}
