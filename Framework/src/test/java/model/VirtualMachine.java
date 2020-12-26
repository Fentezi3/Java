package model;

import java.util.Objects;

public class VirtualMachine {
    private String calculatorType;
    private String numberOfInstance;
    private String operatingSystem;
    private String machineClass;
    private String machineSeries;
    private String machineType;
    private String numberOfGPUs;
    private String gpuType;
    private String localSSD;
    private String dataCenter;
    private String committedUsage;

    public VirtualMachine(String calculatorType, String numberOfInstance, String operatingSystem, String machineClass,
                          String machineSeries, String machineType, String numberOfGPUs, String gpuType, String localSSD,
                          String dataCenter, String committedUsage) {
        this.calculatorType = calculatorType;
        this.numberOfInstance = numberOfInstance;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.dataCenter = dataCenter;
        this.committedUsage = committedUsage;
    }

    public String getCalculatorType() {
        return calculatorType;
    }

    public void setCalculatorType(String calculatorType) {
        this.calculatorType = calculatorType;
    }

    public String getNumberOfInstance() {
        return numberOfInstance;
    }

    public void setNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "VirtualMachine{" +
                "calculatorType='" + calculatorType + '\'' +
                ", numberOfInstance='" + numberOfInstance + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineSeries='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenter='" + dataCenter + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachine virtualMachine = (VirtualMachine) o;
        return Objects.equals(calculatorType, virtualMachine.calculatorType) &&
                Objects.equals(numberOfInstance, virtualMachine.numberOfInstance) &&
                Objects.equals(operatingSystem, virtualMachine.operatingSystem) &&
                Objects.equals(machineClass, virtualMachine.machineClass) &&
                Objects.equals(machineSeries, virtualMachine.machineSeries) &&
                Objects.equals(machineType, virtualMachine.machineType) &&
                Objects.equals(numberOfGPUs, virtualMachine.numberOfGPUs) &&
                Objects.equals(gpuType, virtualMachine.gpuType) &&
                Objects.equals(localSSD, virtualMachine.localSSD) &&
                Objects.equals(dataCenter, virtualMachine.dataCenter) &&
                Objects.equals(committedUsage, virtualMachine.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculatorType, numberOfInstance, operatingSystem, machineClass, machineSeries, machineType,
                numberOfGPUs, gpuType, localSSD, dataCenter, committedUsage);
    }
}
