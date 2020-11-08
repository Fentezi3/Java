package com.remiz.module4;

import com.remiz.module4.bean.*;
import com.remiz.module4.scan.ScannerWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        ElectricDevice fridge = new Fridge(1000, true);
        ElectricDevice heater = new Heater(500, false);
        ElectricDevice airConditioner = new AirConditioner(400, false);
        ElectricDevice television = new TV(500, false);
        ElectricDevice playstation = new PS(300, false);
        ElectricDevice computer = new Computer(1000, true);
        ElectricDevice notebook = new Computer(900, true);
        ElectricDevice stove = new Stove(450, true);
        ElectricDevice microwave = new Microwave(800, false);
        ElectricDevice multiCooker = new Multicooker(350, false);
        ElectricDevice washer = new Washer(1500, true);
        ElectricDevice dishWasher = new DishWasher(1200, false);
        ElectricDevice vacuumCleaner = new VacuumCleaner(150, true);

        List<ElectricDevice> devicesList = new ArrayList<>();
        devicesList.add(fridge);
        devicesList.add(heater);
        devicesList.add(airConditioner);
        devicesList.add(television);
        devicesList.add(playstation);
        devicesList.add(computer);
        devicesList.add(notebook);
        devicesList.add(stove);
        devicesList.add(microwave);
        devicesList.add(multiCooker);
        devicesList.add(washer);
        devicesList.add(dishWasher);
        devicesList.add(vacuumCleaner);

        Devices devices = new Devices();
        devices.setDeviceList(devicesList);

        JAXBContext context = JAXBContext.newInstance(ElectricDevice.class, AirConditioner.class, Computer.class, DishWasher.class,
                Fridge.class, Heater.class, Microwave.class, Multicooker.class, PS.class, Stove.class, TV.class, VacuumCleaner.class,
                Washer.class, Devices.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(devices, new File("./devices.xml"));

//        JAXBContext context = JAXBContext.newInstance(ElectricDevice.class, AirConditioner.class, Computer.class, DishWasher.class,
//                Fridge.class, Heater.class, Microwave.class, Multicooker.class, PS.class, Stove.class, TV.class, VacuumCleaner.class,
//                Washer.class, Devices.class);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        Devices unmarshalledDevices = (Devices) unmarshaller.unmarshal(new FileReader("./devices.xml"));
//        System.out.println(unmarshalledDevices.toString());
//
//        List<ElectricDevice> devicesList = unmarshalledDevices.getDeviceList();

        ScannerWrapper scanner = new ScannerWrapper();
        int check = 0;
        try {
            do {
                scanner.openScanner();
                System.out.println("-1.Switched on devise\n-2.Calculate the power sum consumption" +
                        "\n-3.Sort devices by power\n-4.Find the required device by range\n-5.What devices can do?" +
                        "\n-6.Finish work");
                int enteredNumber = scanner.readInput();
                if (enteredNumber == 1) {
                    switchOnDevices(devicesList);
                } else if (enteredNumber == 2) {
                    calculateSumPower(devicesList);
                } else if (enteredNumber == 3) {
                    sortElectricDevicesByPower(devicesList);
                } else if (enteredNumber == 4) {
                    do {
                        System.out.println("Choose a suitable power range:\n-1.150-450\n-2.900-1000\n-3.1000-1500\n" +
                                "-4.Go to main menu");
                        check = scanner.readInput();
                        findDeviceByRange(check, devicesList);
                    } while (check != 4);
                } else if (enteredNumber == 5) {
                    do {
                        System.out.println("What doing:\n-1.cleaning devices\n-2.cooking devices\n-3.entertaining devices" +
                                "\n-4.changing temperature devices\n-5.Go to main menu");
                        check = scanner.readInput();
                        outputDeviceAction(check, devicesList);
                    } while (check != 5);
                } else if (enteredNumber == 6) {
                    System.out.println("Bye-bye!");
                    check = 1;
                } else {
                    System.out.println("Please,enter number from 1 to 5");
                }
            } while (check != 1);
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

    private static void findDeviceByRange(int check, List<ElectricDevice> devicesList) {
        Comparator<ElectricDevice> compare = Comparator.comparing(ElectricDevice::getPower);
        List<ElectricDevice> minRange = new ArrayList<>();
        List<ElectricDevice> middleRange = new ArrayList<>();
        List<ElectricDevice> maxRange = new ArrayList<>();
        for (ElectricDevice device : devicesList) {
            if (device.getPower() >= 150 && device.getPower() <= 450) {
                minRange.add(device);
            } else if (device.getPower() >= 500 && device.getPower() <= 900) {
                middleRange.add(device);
            } else if (device.getPower() >= 1000 && device.getPower() <= 1500) {
                maxRange.add(device);
            }
        }
        if (check == 1) {
            minRange.sort(compare);
            for (ElectricDevice device : minRange) {
                System.out.println(device);
            }
        } else if (check == 2) {
            middleRange.sort(compare);
            for (ElectricDevice device : middleRange) {
                System.out.println(device);
            }
        } else if (check == 3) {
            maxRange.sort(compare);
            for (ElectricDevice device : maxRange) {
                System.out.println(device);
            }
        } else if (check == 4) {
            System.out.println("Bye!");
        } else {
            System.out.println("Please, enter number from 1 to 4");
        }
    }

    private static void outputDeviceAction(int check, List<ElectricDevice> devicesList) {
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
        if (check == 1) {
            for (ICleaner device : cleaningDevices) {
                System.out.println(device);
                device.cleaner();
            }
        } else if (check == 2) {
            for (ICooking device : cookingDevices) {
                System.out.println(device);
                device.cooking();
            }
        } else if (check == 3) {
            for (IEntertain device : entertainDevices) {
                System.out.println(device);
                device.entertain();
            }
        } else if (check == 4) {
            for (IChangeTemperature device : changeTemperaturesDevices) {
                System.out.println(device);
                device.changeTemperature();
            }
        } else if (check == 5) {
            System.out.println("Bye!");
        } else {
            System.out.println("Please, enter number from 1 to 4");
        }
    }
}
