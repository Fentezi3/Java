package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Heater extends ElectricDevice implements IChangeTemperature {
    public Heater() {
    }

    public Heater(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    public void changeTemperature() {
        System.out.println("I warm the room.");
    }
}
