package com.test.train;

import com.test.train.model.Train;
import com.test.train.util.LocomotiveUtil;
import com.test.train.util.TrainUtil;
import com.test.train.util.WagonUtil;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static com.test.train.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TrainTest {

    @Test
    void shouldCalculateEmptyWeightOfTrain() {
        double actualEmptyWeightOfTrain = TrainUtil.queryEmptyWeight(train);

        assertEquals(expectedEmptyWeightOfTrain, actualEmptyWeightOfTrain);
    }

    @Test
    void shouldCalculateMaxNumberOfPassengers() {
        double actualMaxNumberOfPassengers = LocomotiveUtil.queryMaxNumberOfPassengers(train.getLocomotives());

        assertEquals(expectedMaxNumberOfPassengers, actualMaxNumberOfPassengers);
    }

    @Test
    void shouldCalculateMaxLoadingWeightForGoods() {
        double actualLoadingWeightForGoods = LocomotiveUtil.queryMaxLoadingWeightForGoods(train.getLocomotives());

        assertEquals(expectedMaxLoadingWeightForGoods, actualLoadingWeightForGoods);
    }

    @Test
    void shouldCalculateMaxLoadingWeightOfTrain() {
        double actualMaxLoadingWeightOfTrain = LocomotiveUtil.queryMaxLoadingWeightForTrain(train.getLocomotives());

        assertEquals(expectedMaxLoadingWeightOfTrain, actualMaxLoadingWeightOfTrain);
    }

    @Test
    void shouldCalculateMaxTotalWeightOfTrain() {
        double actualMaxTotalWeighOfTrain = LocomotiveUtil.queryTotalTractiveEffort(train.getLocomotives());

        assertEquals(expectedTotalWeightOfTrain, actualMaxTotalWeighOfTrain);
    }

    @Test
    void shouldCalculateLengthOfTrain() {
        double actualLengthOfTrain = TrainUtil.queryLength(train);

        assertEquals(expectedLengthOfTrain, actualLengthOfTrain);
    }

    @Test
    void shouldCalculateNumberOfConductors() {
        int actualNumberOfConductors = WagonUtil.countNumberOfConductors(train.getWagons());

        assertEquals(expectedNumberOfConductors, actualNumberOfConductors);
    }

    @Test
    void shouldCheckWhetherTrainIsCapableToDrive() {
        boolean actualIsCapableToDrive = TrainUtil.isCapableToDrive(train);

        assertTrue(actualIsCapableToDrive);
    }

    @Test
    void shouldCheckWhetherLocomotiveIsAssignedToTrain() {
        boolean actualIsAssigned = train.getLocomotives().get(0).isAssignedToTrain();

        assertTrue(actualIsAssigned);
    }

    @Test
    void shouldCheckWhetherWagonIsAssignedToTrain() {
        boolean actualIsAssigned = train.getWagons().get(1).isAssignedToTrain();

        assertTrue(actualIsAssigned);
    }

    @Test
    void shouldCheckWhetherTrainIsModified() {
        Train modifiedTrain = modifyTrain(train);

        assertEquals(train.getId(), modifiedTrain.getId());
        assertEquals(modifiedTrain.getWagons(), List.of(wagon, wagon1));
        assertEquals(train.toString(), modifiedTrain.toString());
    }
}
