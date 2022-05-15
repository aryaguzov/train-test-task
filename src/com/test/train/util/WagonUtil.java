package com.test.train.util;

import com.test.train.model.Wagon;

import java.util.List;

public class WagonUtil {

    public static final int numberOfPassengersForOneConductor = 50;

    public static final double averageWeightOfPassenger = 75.0;

    private WagonUtil() {
    }

    public static int countNumberOfConductors(List<Wagon> wagons) {
        int passengers = countPassengers(wagons);

        return passengers == 0 ? 0 : (int) Math.ceil((double) passengers / numberOfPassengersForOneConductor);
    }

    public static double queryTotalWeight(List<Wagon> wagons) {
        return queryLoadingWeightOfPassengers(wagons) + queryLoadingWeightForGoods(wagons) + queryEmptyWeight(wagons);
    }

    private static double queryLoadingWeightOfPassengers(List<Wagon> wagons) {
        return countPassengers(wagons) * averageWeightOfPassenger;
    }

    private static double queryLoadingWeightForGoods(List<Wagon> wagons) {
        return wagons.stream()
                .mapToDouble(Wagon::getMaxLoadingWeightForGoods)
                .sum();
    }

    private static double queryEmptyWeight(List<Wagon> wagons) {
        return wagons.stream()
                .mapToDouble(Wagon::getEmptyWeight)
                .sum();
    }

    private static int countPassengers(List<Wagon> wagons) {
        return wagons.stream()
                .mapToInt(Wagon::getNumberOfPassengers)
                .sum();
    }
}
