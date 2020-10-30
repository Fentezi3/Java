package com.example.module3.plane;

import java.util.Comparator;

public enum PlaneComparator implements Comparator<Plane> {
    MAX_FLIGHT_DISTANCE{
        @Override
        public int compare(Plane plane1, Plane plane2){
            return plane1.getMaxFlightDistance() - plane2.getMaxFlightDistance();
        }
    },
    MAX_SPEED {
        @Override
        public int compare(Plane plane1, Plane plane2){
            return plane1.getMaxSpeed() - plane2.getMaxSpeed();
        }
    },
    LOAD_CAPACITY {
        @Override
        public int compare(Plane plane1, Plane plane2){
            return plane1.getMaxLoadCapacity() - plane2.getMaxLoadCapacity();
        }
    }
}
