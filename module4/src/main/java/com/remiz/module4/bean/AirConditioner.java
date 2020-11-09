package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class AirConditioner extends ElectricDevice implements IChangeTemperature {
    public AirConditioner() {
    }

    public AirConditioner(int power, boolean isSwitchedOn) {
        super(power, isSwitchedOn);
    }
@Override
    public void changeTemperature() {
        System.out.println("I can cool cool the air.");
    }
}
