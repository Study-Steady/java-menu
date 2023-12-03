package menu.utils;

import static menu.utils.DefaultSymbol.CATEGORY;
import static menu.utils.DefaultSymbol.DEFINE;
import static menu.utils.DefaultSymbol.NEW_LINE;
import static menu.utils.DefaultSymbol.RESULT_DELIMETER;
import static menu.utils.DefaultSymbol.RESULT_END;
import static menu.utils.DefaultSymbol.RESULT_START;

import menu.domain.coach.Coach;
import menu.domain.coach.CoachManager;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;
import menu.domain.menu.MenuCategoryGroup;

public class OutputFormatter {
    private OutputFormatter() {
    }

    public static String format(MenuCategoryGroup menuCategoryGroup, CoachManager coachManager) {
        StringBuilder sb = new StringBuilder();

        sb.append(RESULT_START.getSymbol());
        sb.append(DEFINE.getSymbol());
        for (int i = 0; i < 5; i++) {
            sb.append(RESULT_DELIMETER.getSymbol());
            sb.append(DayOfWeek.fromNum(i + 1).getDayOfWeek());
        }
        sb.append(RESULT_END.getSymbol());
        sb.append(NEW_LINE.getSymbol());

        sb.append(RESULT_START.getSymbol());
        sb.append(CATEGORY.getSymbol());
        for(MenuCategory category: menuCategoryGroup.getMenuCategoryGroup()) {
            sb.append(RESULT_DELIMETER.getSymbol());
            sb.append(category.getName());
        }
        sb.append(RESULT_END.getSymbol());
        sb.append(NEW_LINE.getSymbol());

        for (Coach coach: coachManager.getCoaches()) {
            sb.append(RESULT_START.getSymbol());
            sb.append(coach.getName().getName());
            for (Menu menu: coach.getMenuHistory().getHistory()) {
                sb.append(RESULT_DELIMETER.getSymbol());
                sb.append(menu.getName());
            }
            sb.append(RESULT_END.getSymbol());
            sb.append(NEW_LINE.getSymbol());
        }


        return sb.toString();
    }
}
