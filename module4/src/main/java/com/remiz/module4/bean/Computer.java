package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Computer extends ElectricDevice implements IEntertain {
    public Computer() {
    }

    public Computer(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    public void entertain() {
        System.out.println("I help you with your work.");
    }
}
