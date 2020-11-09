package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class VacuumCleaner extends ElectricDevice implements ICleaner {
    public VacuumCleaner() {
    }

    public VacuumCleaner(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }
    @Override
    public void clean() {
        System.out.println("I can clean floor in your flat.");
    }
}
