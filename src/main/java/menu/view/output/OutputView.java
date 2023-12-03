package menu.view.output;

import java.util.List;
import menu.domain.coach.dto.RecommendDto;
import menu.view.output.formatter.OutputFormatter;

public class OutputView implements Printer {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMenuRecommendResult(List<String> menuTypes, List<RecommendDto> recommendDtos) {
        OutputFormatter outputFormatter = new OutputFormatter();
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(outputFormatter.formatCategoryResult(menuTypes));
        for (RecommendDto recommendDto : recommendDtos) {
            String result = outputFormatter.formatCoachResult(recommendDto);
            System.out.println(result);
        }
    }

    public void printMessage(Output output, Object... args) {
        System.out.printf(output.message, args);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void printMessage(Output output) {
        System.out.println(output.message);
    }

    @Override
    public void printfMessage(Output output, Object... args) {
        System.out.printf(output.message, args);
    }
}
