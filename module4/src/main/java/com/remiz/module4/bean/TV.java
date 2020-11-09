package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class TV extends ElectricDevice implements IEntertain {
    public TV() {
    }

    public TV(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }
    @Override
    public void entertain() {
        System.out.println("I show movie");
    }
}
