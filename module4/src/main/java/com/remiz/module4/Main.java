package com.remiz.module4;

import com.remiz.module4.bean.*;
import com.remiz.module4.scan.ScannerWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private final static int OPTION_SWITCH_DEVICES_ON = 1;
    private final static int OPTION_CALCULATE_SUM_POWER = 2;
    private final static int OPTION_SORT_DEVICES_BY_POWER = 3;
    private final static int OPTION_FIND_DEVICES_BY_POWER_RANGE = 4;
    private final static int OPTION_CHOOSE_DEVICES_BY_THEIR_ACTION = 5;
    private final static int OPTION_FINISH_WORK = -1;

    private final static int POWER_VERY_LOW = 150;
    private final static int POWER_LOW = 450;
    private final static int POWER_MIDDLE = 500;
    private final static int POWER_HIGH = 900;
    private final static int POWER_VERY_HIGH = 1000;
    private final static int POWER_EXTRA_HIGH = 1500;
    private final static int INPUT_MINIMAL_RANGE = 1;
    private final static int INPUT_MIDDLE_RANGE = 2;
    private final static int INPUT_MAXIMAL_RANGE = 3;

    private final static int ACTIONS_BY_CLEANING_DEVICES = 1;
    private final static int ACTIONS_BY_COOKING_DEVICES = 2;
    private final static int ACTION_BY_ENTERTAINING_DEVICES = 3;
    private final static int ACTION_BY_CHANGING_TEMPERATURE_DEVICES = 4;
    private static List<ElectricDevice> devicesList = new ArrayList<>();

    public static void main(String[] args) {
        devicesList = unmarshallingDevicesFromFile();

        ScannerWrapper scanner = new ScannerWrapper();
        int check = 0;
        try {
            while (check != OPTION_FINISH_WORK) {
                String outputText;
                scanner.openScanner();
                outputText = "Please, choose option:"
                        + String.format("\n-%2d.Switched on devise", OPTION_SWITCH_DEVICES_ON)
                        + String.format("\n-%2d.Calculate the power sum consumption", OPTION_CALCULATE_SUM_POWER)
                        + String.format("\n-%2d.Sort devices by power", OPTION_SORT_DEVICES_BY_POWER)
                        + String.format("\n-%2d.Find the required device by range", OPTION_FIND_DEVICES_BY_POWER_RANGE)
                        + String.format("\n-%2d.What devices can do?", OPTION_CHOOSE_DEVICES_BY_THEIR_ACTION)
                        + String.format("\n-(%2d).Finish work", OPTION_FINISH_WORK);
                System.out.println(outputText);
                int option = scanner.readInput();
                switch (option) {
                    case OPTION_SWITCH_DEVICES_ON:
                        switchOnDevices();
                        System.out.println();
                        break;
                    case OPTION_CALCULATE_SUM_POWER:
                        calculateSumPower();
                        System.out.println();
                        break;
                    case OPTION_SORT_DEVICES_BY_POWER:
                        sortElectricDevicesByPower();
                        System.out.println();
                        break;
                    case OPTION_FIND_DEVICES_BY_POWER_RANGE:
                        outputText = "Choose a suitable power range:\n"
                                + String.format("-%2d. %dW - %dW\n", INPUT_MINIMAL_RANGE, POWER_VERY_LOW, POWER_LOW)
                                + String.format("-%2d. %dW - %dW\n", INPUT_MIDDLE_RANGE, POWER_MIDDLE, POWER_HIGH)
                                + String.format("-%2d. %dW - %dW\n", INPUT_MAXIMAL_RANGE, POWER_VERY_HIGH, POWER_EXTRA_HIGH)
                                + String.format("-(%2d).Go to main menu", OPTION_FINISH_WORK);
                        do {
                            System.out.println(outputText);
                            option = scanner.readInput();
                            findDevicesByRange(option);
                            System.out.println();
                        } while (option != OPTION_FINISH_WORK);
                        break;
                    case OPTION_CHOOSE_DEVICES_BY_THEIR_ACTION:
                        outputText = "What doing:\n"
                                + String.format("-%d.cleaning devices\n", ACTIONS_BY_CLEANING_DEVICES)
                                + String.format("-%d.cooking devices\n", ACTIONS_BY_COOKING_DEVICES)
                                + String.format("-%d.entertaining devices\n", ACTION_BY_ENTERTAINING_DEVICES)
                                + String.format("-%d.changing temperature devices\n", ACTION_BY_CHANGING_TEMPERATURE_DEVICES)
                                + String.format("-(%d).Go to main menu", OPTION_FINISH_WORK);
                        do {
                            System.out.println(outputText);
                            option = scanner.readInput();
                            outputDeviceAction(option);
                            System.out.println();
                        } while (option != OPTION_FINISH_WORK);
                        break;
                    case OPTION_FINISH_WORK:
                        System.out.println("Bye-bye!");
                        System.out.println();
                        check = OPTION_FINISH_WORK;
                        break;
                    default:
                        System.out.println("Please,enter...");
                        System.out.println();
                        break;
                }
            }
        } finally {
            scanner.closeScanner();
        }
    }

    private static List<ElectricDevice> unmarshallingDevicesFromFile() {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(ElectricDevice.class, AirConditioner.class, Computer.class,
                    DishWasher.class, Fridge.class, Heater.class, Microwave.class, Multicooker.class, PS.class, Stove.class,
                    TV.class, VacuumCleaner.class, Washer.class, Devices.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Devices unmarshalledDevices = null;
        try {
            unmarshalledDevices = (Devices) unmarshaller.unmarshal(new FileReader(
                    "src/main/resources/devices.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        List<ElectricDevice> devicesList = unmarshalledDevices.getDeviceList();
        return devicesList;
    }

    private static void switchOnDevices() {
        for (ElectricDevice device : devicesList) {
            device.switchOn();
            System.out.println(device);
        }
    }

    private static void calculateSumPower() {
        int sumPower = 0;
        for (ElectricDevice device : devicesList) {
            sumPower += device.getPower();
        }
        System.out.println("All devices summary power: " + sumPower);
    }

    private static void sortElectricDevicesByPower() {
        Comparator<ElectricDevice> comparator = Comparator.comparing(ElectricDevice::getPower);
        devicesList.sort(comparator);
        for (ElectricDevice device : devicesList) {
            System.out.println(device.toString());
        }
    }

    private static void findDevicesByRange(int option) {
        switch (option) {
            case INPUT_MINIMAL_RANGE:
                printSortedDeviceListWithPowerInRange(POWER_VERY_LOW, POWER_LOW);
                break;
            case INPUT_MIDDLE_RANGE:
                printSortedDeviceListWithPowerInRange(POWER_MIDDLE, POWER_HIGH);
                break;
            case INPUT_MAXIMAL_RANGE:
                printSortedDeviceListWithPowerInRange(POWER_VERY_HIGH, POWER_EXTRA_HIGH);
                break;
            case OPTION_FINISH_WORK:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Please, enter ...");
                break;
        }
    }

    private static void printSortedDeviceListWithPowerInRange(int lowerRangeBound, int upperRangeBound) {
        Comparator<ElectricDevice> comparator = Comparator.comparing(ElectricDevice::getPower);
        List<ElectricDevice> devices = new ArrayList<>();
        for (ElectricDevice device : devicesList) {
            if (device.getPower() >= lowerRangeBound && device.getPower() <= upperRangeBound) {
                devices.add(device);
                devices.sort(comparator);
            }
        }
        for (ElectricDevice rangedDevice : devices) {
            System.out.println(rangedDevice);
        }
    }

    private static void outputDeviceAction(int option) {
        List<ElectricDevice> deviceActionList = new ArrayList<>();
        switch (option) {
            case ACTIONS_BY_CLEANING_DEVICES:
                for (ElectricDevice device : devicesList) {
                    if (device instanceof IClean) {
                        deviceActionList.add(device);
                    }
                }
                for (ElectricDevice clean : deviceActionList) {
                    System.out.println(clean);
                    ((IClean) clean).clean();
                }
                break;
            case ACTIONS_BY_COOKING_DEVICES:
                for (ElectricDevice device : devicesList) {
                    if (device instanceof ICook) {
                        deviceActionList.add(device);
                    }
                }
                for (ElectricDevice cook : deviceActionList) {
                    System.out.println(cook);
                    ((ICook) cook).cook();
                }
                break;
            case ACTION_BY_ENTERTAINING_DEVICES:
                for (ElectricDevice device : devicesList) {
                    if (device instanceof IEntertain) {
                        deviceActionList.add(device);
                    }
                }
                for (ElectricDevice entertain : deviceActionList) {
                    System.out.println(entertain);
                    ((IEntertain) entertain).entertain();
                }
                break;
            case ACTION_BY_CHANGING_TEMPERATURE_DEVICES:
                for (ElectricDevice device : devicesList) {
                    if (device instanceof IChangeTemperature) {
                        deviceActionList.add(device);
                    }
                }
                for (ElectricDevice temperature : deviceActionList) {
                    System.out.println(temperature);
                    ((IChangeTemperature) temperature).changeTemperature();
                }
                break;
            case OPTION_FINISH_WORK:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Please, enter...");
                break;
        }
    }
}
