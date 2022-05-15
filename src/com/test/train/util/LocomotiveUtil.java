package com.test.train.util;

import com.test.train.model.Locomotive;

import java.util.List;

public class LocomotiveUtil {

    private LocomotiveUtil() {
    }

    public static int queryMaxNumberOfPassengers(List<Locomotive> locomotives) {
        return locomotives.stream()
                .mapToInt(Locomotive::getMaxNumberOfPassengers)
                .sum();
    }

    public static double queryMaxLoadingWeightForGoods(List<Locomotive> locomotives) {
        return locomotives.stream()
                .mapToDouble(Locomotive::getMaxLoadingWeightForGoods)
                .sum();
    }

    public static double queryMaxLoadingWeightForTrain(List<Locomotive> locomotives) {
        return locomotives.stream()
                .mapToDouble(locomotive -> locomotive.getTractiveEffort() - locomotive.getEmptyWeight())
                .sum();
    }

    public static double queryTotalTractiveEffort(List<Locomotive> locomotives) {
        return locomotives.stream()
                .mapToDouble(Locomotive::getTractiveEffort)
                .sum();
    }
}
