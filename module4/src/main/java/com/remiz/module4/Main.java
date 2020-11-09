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
    private final static int OPTION_FINISH_WORK = 6;

    private final static int POWER_VERY_LOW = 150;
    private final static int POWER_LOW = 450;
    private final static int POWER_MIDDLE = 500;
    private final static int POWER_HIGH = 900;
    private final static int POWER_VERY_HIGH = 1000;
    private final static int POWER_EXTRA_HIGH = 1500;
    private final static int INPUT_MINIMAL_RANGE = 1;
    private final static int INPUT_MIDDLE_RANGE = 2;
    private final static int INPUT_MAXIMAL_RANGE = 3;
    private final static int INPUT_FINISH_WORK = 4;

    private final static int ACTIONS_BY_CLEANING_DEVICES = 1;
    private final static int ACTIONS_BY_COOKING_DEVICES = 2;
    private final static int ACTION_BY_ENTERTAINING_DEVICES = 3;
    private final static int ACTION_BY_CHANGING_TEMPERATURE_DEVICES = 4;
    private final static int FINISH_WORK = 5;

    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(ElectricDevice.class, AirConditioner.class, Computer.class,
                DishWasher.class, Fridge.class, Heater.class, Microwave.class, Multicooker.class, PS.class, Stove.class,
                TV.class, VacuumCleaner.class, Washer.class, Devices.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Devices unmarshalledDevices = (Devices) unmarshaller.unmarshal(new FileReader("./devices.xml"));
        System.out.println(unmarshalledDevices.toString());

        List<ElectricDevice> devicesList = unmarshalledDevices.getDeviceList();

        ScannerWrapper scanner = new ScannerWrapper();
        int check = 0;
        try {
            while (check != 1) {
                scanner.openScanner();
                System.out.println("-1.Switched on devise\n-2.Calculate the power sum consumption" +
                        "\n-3.Sort devices by power\n-4.Find the required device by range\n-5.What devices can do?" +
                        "\n-6.Finish work");
                int option = scanner.readInput();
                switch (option) {
                    case OPTION_CHOOSE_SWITCHED_ON_DEVICES:
                        switchOnDevices(devicesList);
                        System.out.println();
                        break;
                    case OPTION_CALCULATE_SUM_POWER:
                        calculateSumPower(devicesList);
                        System.out.println();
                        break;
                    case OPTION_SORT_DEVICES_BY_POWER:
                        sortElectricDevicesByPower(devicesList);
                        System.out.println();
                        break;
                    case OPTION_FIND_DEVICES_BY_POWER_RANGE:
                        do {
                            System.out.println("Choose a suitable power range:\n-1.150-450\n-2.900-1000\n-3.1000-1500" +
                                    "\n-4.Go to main menu");
                            option = scanner.readInput();
                            findDeviceByRange(option, devicesList);
                            System.out.println();
                        } while (option != INPUT_FINISH_WORK);
                        break;
                    case OPTION_CHOOSE_DEVICES_BY_THEIR_ACTION:
                        do {
                            System.out.println("What doing:\n-1.cleaning devices\n-2.cooking devices\n" +
                                    "-3.entertaining devices\n-4.changing temperature devices\n-5.Go to main menu");
                            option = scanner.readInput();
                            outputDeviceAction(check, devicesList);
                            System.out.println();
                        } while (option != FINISH_WORK);
                        break;
                    case OPTION_FINISH_WORK:
                        System.out.println("Bye-bye!");
                        System.out.println();
                        check = 1;
                        break;
                    default:
                        System.out.println("Please,enter number from 1 to 6");
                        System.out.println();
                        break;
                }
            }
        } finally {
            scanner.closeScanner();
        }
    }

    private static void switchOnDevices(List<ElectricDevice> devicesList) {
        for (ElectricDevice device : devicesList) {
            device.switchOn();
            System.out.println(device);
        }
    }

    private static void calculateSumPower(List<ElectricDevice> devicesList) {
        int sumPower = 0;
        for (ElectricDevice device : devicesList) {
            sumPower += device.getPower();
        }
        System.out.println(sumPower);
    }

    private static void sortElectricDevicesByPower(List<ElectricDevice> devicesList) {
        Comparator<ElectricDevice> compare = Comparator.comparing(ElectricDevice::getPower);
        devicesList.sort(compare);
        for (ElectricDevice device : devicesList) {
            System.out.println(device.toString());
        }
    }

    private static void findDeviceByRange(int option, List<ElectricDevice> devicesList) {
        Comparator<ElectricDevice> compare = Comparator.comparing(ElectricDevice::getPower);
        List<ElectricDevice> minRange = new ArrayList<>();
        List<ElectricDevice> middleRange = new ArrayList<>();
        List<ElectricDevice> maxRange = new ArrayList<>();
        for (ElectricDevice device : devicesList) {
            if (device.getPower() >= POWER_VERY_LOW && device.getPower() <= POWER_LOW) {
                minRange.add(device);
            } else if (device.getPower() >= POWER_MIDDLE && device.getPower() <= POWER_HIGH) {
                middleRange.add(device);
            } else if (device.getPower() >= POWER_VERY_HIGH && device.getPower() <= POWER_EXTRA_HIGH) {
                maxRange.add(device);
            }
        }
        switch (option) {
            case INPUT_MINIMAL_RANGE:
                minRange.sort(compare);
                for (ElectricDevice device : minRange) {
                    System.out.println(device);
                }
            case INPUT_MIDDLE_RANGE:
                middleRange.sort(compare);
                for (ElectricDevice device : middleRange) {
                    System.out.println(device);
                }
            case INPUT_MAXIMAL_RANGE:
                maxRange.sort(compare);
                for (ElectricDevice device : maxRange) {
                    System.out.println(device);
                }
            case INPUT_FINISH_WORK:
                System.out.println("Bye!");
            default:
                System.out.println("Please, enter number from 1 to 4");
        }
    }

    private static void outputDeviceAction(int option, List<ElectricDevice> devicesList) {
        List<ICleaner> cleaningDevices = new ArrayList<>();
        List<ICooking> cookingDevices = new ArrayList<>();
        List<IEntertain> entertainDevices = new ArrayList<>();
        List<IChangeTemperature> changeTemperaturesDevices = new ArrayList<>();
        for (ElectricDevice device : devicesList) {
            if (device instanceof ICleaner) {
                cleaningDevices.add((ICleaner) device);
            } else if (device instanceof IChangeTemperature) {
                changeTemperaturesDevices.add((IChangeTemperature) device);
            } else if (device instanceof ICooking) {
                cookingDevices.add((ICooking) device);
            } else if (device instanceof IEntertain) {
                entertainDevices.add((IEntertain) device);
            }
        }
        switch (option) {
            case ACTIONS_BY_CLEANING_DEVICES:
                for (ICleaner device : cleaningDevices) {
                    System.out.println(device);
                    device.clean();
                }
            case ACTIONS_BY_COOKING_DEVICES:
                for (ICooking device : cookingDevices) {
                    System.out.println(device);
                    device.cook();
                }
            case ACTION_BY_ENTERTAINING_DEVICES:
                for (IEntertain device : entertainDevices) {
                    System.out.println(device);
                    device.entertain();
                }
            case ACTION_BY_CHANGING_TEMPERATURE_DEVICES:
                for (IChangeTemperature device : changeTemperaturesDevices) {
                    System.out.println(device);
                    device.changeTemperature();
                }
            case FINISH_WORK:
                System.out.println("Bye!");
            default:
                System.out.println("Please, enter number from 1 to 4");
        }
    }
}
