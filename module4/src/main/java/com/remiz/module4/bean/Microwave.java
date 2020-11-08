package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Microwave extends ElectricDevice implements ICooking {
    public Microwave() {
    }

    public Microwave(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    public void cooking() {
        System.out.println("I can warm up your food.");
    }
}
