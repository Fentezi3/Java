package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class DishWasher extends ElectricDevice implements IClean {
    public DishWasher() {
    }

    public DishWasher(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    @Override
    public void clean() {
        System.out.println("I can wash your dishes.");
    }
}
