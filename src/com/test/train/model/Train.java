package com.test.train.model;

import com.test.train.util.TrainUtil;
import com.test.train.util.WagonUtil;

import java.util.List;
import java.util.UUID;

public class Train {

    private static boolean isModified;

    private UUID id;

    private List<Locomotive> locomotives;

    private List<Wagon> wagons;

    private int numOfConductors;

    private Train() {
    }

    public UUID getId() {
        return id;
    }

    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public int getNumOfConductors() {
        return numOfConductors;
    }

    public boolean isModified() {
        return isModified;
    }

    public static TrainBuilder newBuilder() {
        return new Train().new TrainBuilder();
    }

    public static TrainBuilder modify(Train train) {
        isModified = true;
        return train.new TrainBuilder();
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", locomotives=" + locomotives +
                ", wagons=" + wagons +
                ", numOfConductors=" + numOfConductors +
                '}';
    }

    public class TrainBuilder {

        private TrainBuilder() {
        }

        public TrainBuilder id() {
            Train.this.id = UUID.randomUUID();
            return this;
        }

        public TrainBuilder locomotives(List<Locomotive> locomotives) {
            Train.this.locomotives = locomotives;
            return this;
        }

        public TrainBuilder wagons(List<Wagon> wagons) {
            Train.this.wagons = wagons;
            return this;
        }

        public TrainBuilder numOfConductors() {
            Train.this.numOfConductors = WagonUtil.countNumberOfConductors(Train.this.getWagons());
            return this;
        }

        public Train build() {
            Train train = Train.this;
            validate(train);
            return train;
        }

        private void validate(Train train) {
            boolean capableToDrive = TrainUtil.isCapableToDrive(train);

            if (!capableToDrive) {
                throw new IllegalArgumentException("The train is not capable to drive because of overloading.");
            }

            if (!Train.this.isModified()) {
                assignLocomotivesToTrain(train);
                assignWagonsToTrain(train);
            }
        }

        public void assignLocomotivesToTrain(Train train) {
            train.getLocomotives()
                    .forEach(locomotive -> {
                        if (locomotive.isAssignedToTrain()) {
                            throw new IllegalArgumentException("The locomotive is already assigned to the train.");
                        }
                        locomotive.setAssignedToTrain(true);
                    });
        }

        public void assignWagonsToTrain(Train train) {
            train.getWagons()
                    .forEach(wagon -> {
                        if (wagon.isAssignedToTrain()) {
                            throw new IllegalArgumentException("The wagon is already assigned to the train.");
                        }
                        wagon.setAssignedToTrain(true);
                    });
        }
    }
}
