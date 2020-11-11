package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class PS extends ElectricDevice implements IEntertain {
    public PS() {
    }

    public PS(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    @Override
    public void entertain() {
        System.out.println("I can run games.");
    }
}
