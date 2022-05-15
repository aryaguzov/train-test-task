package com.test.train.model;

import java.time.LocalDate;
import java.util.UUID;

public class Wagon {

    private UUID uniqueSerialNumber;

    private String manufacturer;

    private LocalDate yearOfProduction;

    private int numberOfPassengers;

    private double emptyWeight;

    private double length;

    private double maxLoadingWeightForGoods;

    private WagonType type;

    private boolean isAssignedToTrain;

    public Wagon() {
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

    public int getNumberOfPassengers() {
        return numberOfPassengers;
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

    public WagonType getType() {
        return type;
    }

    public boolean isAssignedToTrain() {
        return isAssignedToTrain;
    }

    public void setAssignedToTrain(boolean assignedToTrain) {
        isAssignedToTrain = assignedToTrain;
    }

    public static WagonBuilder newBuilder() {
        return new Wagon().new WagonBuilder();
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "uniqueSerialNumber=" + uniqueSerialNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", numberOfPassengers=" + numberOfPassengers +
                ", emptyWeight=" + emptyWeight +
                ", length=" + length +
                ", maxLoadingWeightForGoods=" + maxLoadingWeightForGoods +
                ", type=" + type +
                ", isAssignedToTrain=" + isAssignedToTrain +
                '}';
    }

    public class WagonBuilder {

        private WagonBuilder() {
        }

        public WagonBuilder uniqueSerialNumber() {
            Wagon.this.uniqueSerialNumber = UUID.randomUUID();
            return this;
        }

        public WagonBuilder manufacturer(String manufacturer) {
            Wagon.this.manufacturer = manufacturer;
            return this;
        }

        public WagonBuilder yearOfProduction(LocalDate yearOfProduction) {
            Wagon.this.yearOfProduction = yearOfProduction;
            return this;
        }

        public WagonBuilder numberOfPassengers(int numberOfPassengers) {
            Wagon.this.numberOfPassengers = numberOfPassengers;
            return this;
        }

        public WagonBuilder emptyWeight(double emptyWeight) {
            Wagon.this.emptyWeight = emptyWeight;
            return this;
        }

        public WagonBuilder length(double length) {
            Wagon.this.length = length;
            return this;
        }

        public WagonBuilder maxLoadingWeightForGoods(double maxLoadingWeightForGoods) {
            Wagon.this.maxLoadingWeightForGoods = maxLoadingWeightForGoods;
            return this;
        }

        public WagonBuilder type(WagonType type) {
            Wagon.this.type = type;
            return this;
        }

        public WagonBuilder assignToTrain(boolean isAssignedToTrain) {
            Wagon.this.isAssignedToTrain = isAssignedToTrain;
            return this;
        }

        public Wagon build() {
            return Wagon.this;
        }
    }
}
