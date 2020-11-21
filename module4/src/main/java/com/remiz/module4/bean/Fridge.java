package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Fridge extends ElectricDevice implements IChangeTemperature {
    public Fridge() {
    }

    public Fridge(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }

    @Override
    public void changeTemperature() {
        System.out.println("I can freeze your food.");
    }
}
