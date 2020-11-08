package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class DishWasher extends ElectricDevice implements ICleaner {
    public DishWasher() {
    }

    public DishWasher(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    public void cleaner() {
        System.out.println("I can wash your dishes.");
    }
}
