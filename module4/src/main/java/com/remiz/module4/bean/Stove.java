package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Stove extends ElectricDevice implements ICooking {
    public Stove() {
    }

    public Stove(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    public void cooking() {
        System.out.println("I can boil and fry your food.");
    }
}
