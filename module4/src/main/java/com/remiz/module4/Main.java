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
    private final static int OPTION_CHOOSE_SWITCHED_ON_DEVICES = 1;
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
    protected static List<ElectricDevice> devicesList;

    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        devicesList = unmarshallingDevicesFromFile();

        ScannerWrapper scanner = new ScannerWrapper();
        int check = 0;
        try {
            while (check != 1) {
                String outputText;
                scanner.openScanner();
                outputText = String.format("-1.Switched on devise\n-2.Calculate the power sum consumption" +
                        "\n-3.Sort devices by power\n-4.Find the required device by range\n-5.What devices can do?" +
                        "\n-(-1).Finish work", OPTION_FINISH_WORK);
                System.out.println(outputText);
                int option = scanner.readInput();
                switch (option) {
                    case OPTION_CHOOSE_SWITCHED_ON_DEVICES:
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
                        outputText = String.format("Choose a suitable power range:\n-1.%d - %d\n-2.%d - %d\n" +
                                        "-3.%d - %d\n-(%d).Go to main menu", POWER_VERY_LOW, POWER_LOW, POWER_MIDDLE,
                                POWER_HIGH, POWER_VERY_HIGH, POWER_EXTRA_HIGH, OPTION_FINISH_WORK);
                        do {
                            System.out.println(outputText);
                            option = scanner.readInput();
                            findDevicesByRange(option);
                            System.out.println();
                        } while (option != OPTION_FINISH_WORK);
                        break;
                    case OPTION_CHOOSE_DEVICES_BY_THEIR_ACTION:
                        outputText = String.format("What doing:\n-%d.cleaning devices\n-%d.cooking devices\n" +
                                        "-%d.entertaining devices\n-%d.changing temperature devices\n" +
                                        "-(%d).Go to main menu", ACTIONS_BY_CLEANING_DEVICES, ACTIONS_BY_COOKING_DEVICES,
                                ACTION_BY_ENTERTAINING_DEVICES, ACTION_BY_CHANGING_TEMPERATURE_DEVICES, OPTION_FINISH_WORK);
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
                        check = 1;
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

    private static List unmarshallingDevicesFromFile() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(ElectricDevice.class, AirConditioner.class, Computer.class,
                DishWasher.class, Fridge.class, Heater.class, Microwave.class, Multicooker.class, PS.class, Stove.class,
                TV.class, VacuumCleaner.class, Washer.class, Devices.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Devices unmarshalledDevices = (Devices) unmarshaller.unmarshal(new FileReader(
                "src\\main\\resources\\devices.xml"));
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
        System.out.println(sumPower);
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
