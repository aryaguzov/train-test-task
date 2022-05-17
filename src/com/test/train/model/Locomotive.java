package com.test.train.model;

import com.test.train.util.WagonUtil;

import java.time.LocalDate;
import java.util.UUID;

public class Locomotive extends AbstractBaseObject {

    private int maxNumberOfPassengers;

    private double tractiveEffort;

    private LocomotiveType type;

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public double getTractiveEffort() {
        return tractiveEffort;
    }

    public LocomotiveType getType() {
        return type;
    }

    public static LocomotiveBuilder newBuilder() {
        return new Locomotive().new LocomotiveBuilder();
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "uniqueSerialNumber=" + uniqueSerialNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", maxNumberOfPassengers=" + maxNumberOfPassengers +
                ", emptyWeight=" + emptyWeight +
                ", length=" + length +
                ", maxLoadingWeightForGoods=" + maxLoadingWeightForGoods +
                ", tractiveEffort=" + tractiveEffort +
                ", type=" + type +
                ", isAssignedToTrain=" + isAssignedToTrain +
                '}';
    }

    public class LocomotiveBuilder {

        private LocomotiveBuilder() {
        }

        public LocomotiveBuilder uniqueSerialNumber() {
            Locomotive.this.uniqueSerialNumber = UUID.randomUUID();
            return this;
        }

        public LocomotiveBuilder manufacturer(String manufacturer) {
            Locomotive.this.manufacturer = manufacturer;
            return this;
        }

        public LocomotiveBuilder yearOfProduction(LocalDate yearOfProduction) {
            Locomotive.this.yearOfProduction = yearOfProduction;
            return this;
        }

        public LocomotiveBuilder maxNumberOfPassengers(int maxNumberOfPassengers) {
            Locomotive.this.maxNumberOfPassengers = maxNumberOfPassengers;
            return this;
        }

        public LocomotiveBuilder emptyWeight(double emptyWeight) {
            Locomotive.this.emptyWeight = emptyWeight;
            return this;
        }

        public LocomotiveBuilder length(double length) {
            Locomotive.this.length = length;
            return this;
        }

        public LocomotiveBuilder maxLoadingWeightForGoods(double maxLoadingWeightForGoods) {
            Locomotive.this.maxLoadingWeightForGoods = maxLoadingWeightForGoods;
            return this;
        }

        public LocomotiveBuilder tractiveEffort() {
            Locomotive.this.tractiveEffort = getMaxLoadingWeightForGoods() + getEmptyWeight()
                    + (getMaxNumberOfPassengers() * WagonUtil.averageWeightOfPassenger);
            return this;
        }

        public LocomotiveBuilder type(LocomotiveType type) {
            Locomotive.this.type = type;
            return this;
        }

        public LocomotiveBuilder assignToTrain(boolean isAssignedToTrain) {
            Locomotive.this.isAssignedToTrain = isAssignedToTrain;
            return this;
        }

        public Locomotive build() {
            return Locomotive.this;
        }
    }
}
