package racingcar.service;

import static racingcar.enums.Integers.MIN_FORWARD_CONDITION;
import static racingcar.enums.Integers.RANDOM_NUMBER_MAX;
import static racingcar.enums.Integers.RANDOM_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingPlayService {


    public void playRacingWith(Cars racingCars) {
        racingCars.stream()
                  .peek(this::checkMoveForward);

    }

    public void checkMoveForward(Car car) {
        if (isCarMoveForward()) {
            car.moveForward();
        }

    }

    private boolean isCarMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN.show(), RANDOM_NUMBER_MAX.show());

        return randomNumber >= MIN_FORWARD_CONDITION.show();
    }

}
