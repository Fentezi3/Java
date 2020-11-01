package com.example.module3;

import com.example.module3.models.ClassificationLevel;
import com.example.module3.models.MilitaryType;
import com.example.module3.plane.ExperimentalPlane;
import com.example.module3.plane.MilitaryPlane;
import com.example.module3.plane.Plane;

import java.util.List;

public class TestServices {
        public static boolean transportMilitaryPlane(List<MilitaryPlane>transportMilitaryPlanes){
            boolean containsTransportOnly = true;
            for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
                if ((militaryPlane.getType() != MilitaryType.TRANSPORT)) {
                    containsTransportOnly = false;
                    break;
                }
            }
            return containsTransportOnly;
        }

        public static boolean sortedPlaneByMaxLoadCapacity(List<? extends Plane> planesSortedByMaxLoadCapacity){
            boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
            for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
                Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
                Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
                if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                    nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                    break;
                }
            }
            return nextPlaneMaxLoadCapacityIsHigherThanCurrent;
        }

        public static boolean hasAtLeastOneBomberInMilitaryPlanes(List<MilitaryPlane> bomberMilitaryPlanes){
            boolean containsOnlyBomber = false;
            for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
                if ((militaryPlane.getType() == MilitaryType.BOMBER)) {
                    containsOnlyBomber = true;
                    break;
                }
            }
            return containsOnlyBomber;
        }

        public static boolean ExperimentalPlanesHasClassificationLevelHigherThanUnclassified(List<ExperimentalPlane> experimentalPlanes){
            boolean hasUnclassifiedPlanes = false;
            for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
                if (experimentalPlane.getClassificationLevel() != ClassificationLevel.UNCLASSIFIED) {
                    hasUnclassifiedPlanes = true;
                    break;
                }
            }return hasUnclassifiedPlanes;
        }
}
