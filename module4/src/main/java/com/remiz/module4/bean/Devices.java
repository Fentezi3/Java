package com.remiz.module4.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Devices {
    @XmlElement(name = "device")
    private List<ElectricDevice> deviceList = null;

    public List<ElectricDevice> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<ElectricDevice> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "deviceList=" + deviceList +
                '}';
    }
}
