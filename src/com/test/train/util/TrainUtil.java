package com.test.train.util;

import com.test.train.model.Locomotive;
import com.test.train.model.Train;
import com.test.train.model.Wagon;

public class TrainUtil {

    private TrainUtil() {
    }

    public static double queryEmptyWeight(Train train) {
        double totalEmptyWeightLocomotives = train.getLocomotives().stream()
                .mapToDouble(Locomotive::getEmptyWeight)
                .sum();

        double totalEmptyWeightWagons = train.getWagons().stream()
                .mapToDouble(Wagon::getEmptyWeight)
                .sum();

        return totalEmptyWeightLocomotives + totalEmptyWeightWagons;
    }

    public static double queryLength(Train train) {
        double lengthOfLocomotives = train.getLocomotives().stream()
                .mapToDouble(Locomotive::getLength)
                .sum();

        double lengthOfWagons = train.getWagons().stream()
                .mapToDouble(Wagon::getLength)
                .sum();

        return lengthOfLocomotives + lengthOfWagons;
    }

    public static boolean isCapableToDrive(Train train) {
        double totalTractiveEffort = LocomotiveUtil.queryMaxLoadingWeightForTrain(train.getLocomotives());
        double totalWagonsWeight = WagonUtil.queryTotalWeight(train.getWagons());

        return totalTractiveEffort > totalWagonsWeight;
    }
}
