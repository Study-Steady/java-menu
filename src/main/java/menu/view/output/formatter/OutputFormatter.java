package menu.view.output.formatter;

import java.util.List;
import menu.domain.coach.dto.RecommendDto;

public class OutputFormatter {

    private static final String RESULT_START_SYMBOL = "[ ";
    private static final String RESULT_END_SYMBOL = " ]";
    private static final String DELIMITER_SYMBOL = " | ";
    private static final String CATEGORY_SYMBOL = "카테고리";

    public String formatCategoryResult(List<String> recommendTypes) {
        return formatType(recommendTypes, CATEGORY_SYMBOL + DELIMITER_SYMBOL);
    }

    public String formatCoachResult(RecommendDto recommendDto) {
        return formatType(recommendDto.recommendFoods(), recommendDto.name() + DELIMITER_SYMBOL);
    }

    private String formatType(List<String> recommendResults, String args) {
        return RESULT_START_SYMBOL + args + String.join(DELIMITER_SYMBOL, recommendResults) + RESULT_END_SYMBOL;
    }
}
