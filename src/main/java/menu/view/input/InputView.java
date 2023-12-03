package menu.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.constant.MenuConstant;
import menu.util.validator.CoachValidator;
import menu.util.validator.HateFoodValidator;

public class InputView implements Reader {

    @Override
    public String readLine() {
        return Console.readLine();
    }

    public List<String> getCoach() {
        System.out.println("점심 메뉴 추천을 시작합니다. \n");

        System.out.println("코치의 이름을 입력해 주세요. (" + MenuConstant.SPLIT_SYMBOL + " 로 구분)");
        return new CoachValidator().validate(readLine());
    }

    public List<String> getHateFoods() {
        return new HateFoodValidator().validate(readLine());
    }
}