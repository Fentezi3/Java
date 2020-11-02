package com.example.module3;

import com.example.module3.model.ClassificationLevel;
import com.example.module3.model.MilitaryType;
import com.example.module3.plane.ExperimentalPlane;
import com.example.module3.plane.MilitaryPlane;
import com.example.module3.plane.Plane;

import java.util.List;

public class TestService {
    public static boolean onlyTransportTypeInMilitaryPlanes(List<MilitaryPlane> transportMilitaryPlanes) {
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() != MilitaryType.TRANSPORT)) {
                return false;
            }
        }
        return true;
    }

    public static boolean sortCheckPlaneByMaxLoadCapacity(List<? extends Plane> planesSortedByMaxLoadCapacity) {
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            if (planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() >
                    planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasAtLeastOneBomberInMilitaryPlanes(List<MilitaryPlane> bomberMilitaryPlanes) {
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.BOMBER)) {
                return true;
            }
        }
        return false;
    }

    public static boolean experimentalPlanesHaveClassificationLevelHigherThanUnclassified(List<ExperimentalPlane> experimentalPlanes) {
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            if (experimentalPlane.getClassificationLevel() != ClassificationLevel.UNCLASSIFIED) {
                return true;
            }
        }
        return false;
    }
}
