package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class ElectricDevice implements ISwitchOn {
    @XmlElement
    protected int power;
    @XmlElement
    protected boolean isSwitchedOn;

    public ElectricDevice() {
    }

    public ElectricDevice(int power, boolean isSwitchedOn) {
        this.power = power;
        this.isSwitchedOn = isSwitchedOn;
    }

    @Override
    public void switchOn() {
        if (isSwitchedOn) {
            System.out.println("The devise is already on.");
        } else {
            System.out.println("Activate!");
        }
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "ElectricDevices{" +
                "power=" + power +
                ", switchOn=" + isSwitchedOn +
                '}';
    }
}
