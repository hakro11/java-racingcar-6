package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import racingcar.domain.AskCarName;
import racingcar.domain.AskHowManyPlayGame;
import racingcar.domain.GameResult;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String result = "";
        AskCarName askCarName = new AskCarName();
        AskHowManyPlayGame askHowManyPlayGame = new AskHowManyPlayGame();
        GameResult gameResult = new GameResult();


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        Map<String, Integer> point = askCarName.askCarName(carName);
        List<String> carNameList = Arrays.asList(carName.split(","));

        System.out.println("시도할 회수는 몇회인가요?");
        int howManyPlayGame = askHowManyPlayGame.askHowManyPlayGame(Console.readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < howManyPlayGame; i++) {

        }

        int winnerPoint = point.values().stream().mapToInt(i -> i).max().getAsInt();
        result = gameResult.gameResult(winnerPoint, carNameList, point);

        System.out.printf("최종 우승자 : %s", result);
    }
}
