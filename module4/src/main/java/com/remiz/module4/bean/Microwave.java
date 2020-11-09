package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Microwave extends ElectricDevice implements ICooking {
    public Microwave() {
    }

    public Microwave(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }
@Override
    public void cook() {
        System.out.println("I can warm up your food.");
    }
}
