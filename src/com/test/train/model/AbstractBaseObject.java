package com.test.train.model;

import java.time.LocalDate;
import java.util.UUID;

public class AbstractBaseObject {

    protected UUID uniqueSerialNumber;

    protected String manufacturer;

    protected LocalDate yearOfProduction;

    protected double emptyWeight;

    protected double length;

    protected double maxLoadingWeightForGoods;

    protected boolean isAssignedToTrain;

    public AbstractBaseObject() {
    }

    public UUID getUniqueSerialNumber() {
        return uniqueSerialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public double getLength() {
        return length;
    }

    public double getMaxLoadingWeightForGoods() {
        return maxLoadingWeightForGoods;
    }

    public boolean isAssignedToTrain() {
        return isAssignedToTrain;
    }

    public void setAssignedToTrain(boolean assignedToTrain) {
        isAssignedToTrain = assignedToTrain;
    }
}
