package com.example.module3.plane;

import com.example.module3.models.ClassificationLevel;
import com.example.module3.models.ExperimentalType;

public class ExperimentalPlane extends Plane {
    private ExperimentalType type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }

    public ExperimentalType getType() {
        return type;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }
}
