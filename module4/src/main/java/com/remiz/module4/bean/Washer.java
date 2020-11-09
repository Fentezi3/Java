package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Washer extends ElectricDevice implements ICleaner {
    public Washer() {
    }

    public Washer(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }
    @Override
    public void clean() {
        System.out.println("I can wash your clothes.");
    }
}
