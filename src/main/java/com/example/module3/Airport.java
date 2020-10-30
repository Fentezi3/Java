// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019
package com.example.module3;

import com.example.module3.models.MilitaryType;
import com.example.module3.plane.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
    return getPlanesByType(PassengerPlane.class);
}

    public List<MilitaryPlane> getMilitaryPlanes() {
        return getPlanesByType(MilitaryPlane.class);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return getPlanesByType(ExperimentalPlane.class);
    }

    private <T extends Plane> List<T> getPlanesByType(Class<T> clazz) {
        List<T> resultPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane.getClass().equals(clazz)) {
                resultPlanes.add((T) plane);
            }
        }
        return resultPlanes;
    }

    public List<MilitaryPlane> filterMilitaryPlanesByType(MilitaryType type){
        List<MilitaryPlane> resultList = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for(MilitaryPlane plane : militaryPlanes){
            if (plane.getType() == type){
                resultList.add(plane);
            }
        }
        return resultList;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public Airport sortByMaxDistance() {
        planes.sort(PlaneComparator.MAX_FLIGHT_DISTANCE);
        return this;
    }

    public Airport sortPlanesByMaxSpeed() {
        planes.sort(PlaneComparator.MAX_SPEED);
        return this;
    }

    public Airport sortPlanesByMaxLoadCapacity() {
        planes.sort(PlaneComparator.LOAD_CAPACITY);
        return this;
    }

    private void print(Collection<? extends Plane> collection) {
        for (Plane plane : collection) {
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "planes=" + planes +
                '}';
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }
}
