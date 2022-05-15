package com.test.train;

import com.test.train.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.test.train.TestData.train;

public class TestData {

    public static final double expectedEmptyWeightOfTrain = 250.0;

    public static final int expectedMaxNumberOfPassengers = 1000;

    public static final double expectedMaxLoadingWeightForGoods = 2000.0;

    public static final double expectedMaxLoadingWeightOfTrain = 77000.0;

    public static final double expectedTotalWeightOfTrain = 77100.0;

    public static final double expectedLengthOfTrain = 340.0;

    public static final int expectedNumberOfConductors = 6;

    public static Locomotive locomotive = Locomotive.newBuilder()
            .uniqueSerialNumber()
            .manufacturer("0")
            .yearOfProduction(LocalDate.of(2022, Month.APRIL, 12))
            .maxNumberOfPassengers(1000)
            .emptyWeight(100.0)
            .length(100.0)
            .maxLoadingWeightForGoods(2000.0)
            .tractiveEffort()
            .type(LocomotiveType.DIESEL)
            .assignToTrain(false)
            .build();

    public static Locomotive locomotiveForModify = Locomotive.newBuilder()
            .uniqueSerialNumber()
            .manufacturer("1")
            .yearOfProduction(LocalDate.of(2022, Month.APRIL, 12))
            .maxNumberOfPassengers(1000)
            .emptyWeight(100.0)
            .length(100.0)
            .maxLoadingWeightForGoods(2000.0)
            .tractiveEffort()
            .type(LocomotiveType.DIESEL)
            .assignToTrain(false)
            .build();

    public static Wagon wagon = Wagon.newBuilder()
            .uniqueSerialNumber()
            .manufacturer("0")
            .yearOfProduction(LocalDate.of(2022, Month.APRIL, 12))
            .numberOfPassengers(100)
            .emptyWeight(50.0)
            .length(80.0)
            .maxLoadingWeightForGoods(500.0)
            .type(WagonType.PASSENGERS)
            .assignToTrain(false)
            .build();

    public static Wagon wagon1 = Wagon.newBuilder()
            .uniqueSerialNumber()
            .manufacturer("1")
            .yearOfProduction(LocalDate.of(2022, Month.APRIL, 12))
            .numberOfPassengers(100)
            .emptyWeight(50.0)
            .length(80.0)
            .maxLoadingWeightForGoods(500.0)
            .type(WagonType.PASSENGERS)
            .assignToTrain(false)
            .build();

    public static Wagon wagon2 = Wagon.newBuilder()
            .uniqueSerialNumber()
            .manufacturer("2")
            .yearOfProduction(LocalDate.of(2022, Month.APRIL, 12))
            .numberOfPassengers(100)
            .emptyWeight(50.0)
            .length(80.0)
            .maxLoadingWeightForGoods(500.0)
            .type(WagonType.PASSENGERS)
            .assignToTrain(false)
            .build();

    public static Train train = Train.newBuilder()
            .id()
            .locomotives(List.of(locomotive))
            .wagons(List.of(wagon, wagon1, wagon2))
            .numOfConductors()
            .build();

    public static Train modifyTrain(Train train) {
        return Train.modify(train)
                .locomotives(List.of(locomotiveForModify))
                .wagons(List.of(wagon, wagon1))
                .build();
    }
}
