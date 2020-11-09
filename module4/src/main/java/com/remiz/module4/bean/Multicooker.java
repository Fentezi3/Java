package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Multicooker extends ElectricDevice implements ICooking {
    public Multicooker() {
    }

    public Multicooker(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }
    @Override
    public void cook() {
        System.out.println("I can boil your food.");
    }
}
