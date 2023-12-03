package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;
import menu.domain.coach.dto.RecommendDto;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuType;
import menu.domain.recommender.RandomRecommender;
import menu.util.constant.MenuConstant;
import menu.view.input.InputView;
import menu.view.output.Output;
import menu.view.output.OutputView;

public class MenuController {

    private static final int MIN_MENU_TYPE_DUPLICATION = 2;
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> coachNames = getCoaches();
        List<Coach> coaches = getCoachHateFood(coachNames);
        List<MenuType> menuTypes = menuRecommend(coaches);
        showRecommendResult(menuTypes, coaches);
    }

    private List<String> getCoaches() {
        return receiveValidatedInput(inputView::getCoach);
    }

    private List<Coach> getCoachHateFood(List<String> coaches) {
        List<Coach> recommends = new ArrayList<>();

        for (String name : coaches) {
            outputView.printfMessage(Output.INPUT_CAN_NOT_EAT_FOOD, name);
            List<String> hateFoods = receiveValidatedInput(inputView::getHateFoods);
            recommends.add(new Coach(name, hateFoods));
        }
        return recommends;
    }

    private List<MenuType> menuRecommend(List<Coach> coaches) {
        List<MenuType> menuTypes = new ArrayList<>();
        for (int index = 0; index < MenuConstant.END_MENU_RECOMMEND; index++) {
            MenuType menuType = pickMenuCategory(menuTypes);
            menuTypes.add(menuType);
            recommendToCoach(menuType, coaches);
        }
        return menuTypes;
    }

    private void showRecommendResult(List<MenuType> menuTypes, List<Coach> coaches) {
        List<RecommendDto> recommendResults = new ArrayList<>();

        for (Coach coach : coaches) {
            recommendResults.add(coach.getTotalRecommend());
        }
        List<String> menuTypeNames = MenuType.convertToNameList(menuTypes);

        outputView.printMenuRecommendResult(menuTypeNames, recommendResults);
        outputView.printMessage(Output.RECOMMEND_RESULT_SUCCESS);
    }

    private void recommendToCoach(MenuType menuType, List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> menus = Menu.getMenuNamesByType(menuType);
            coach.recommendFood(menus);
        }
    }

    private MenuType pickMenuCategory(List<MenuType> menuTypes) {
        MenuType menuType = MenuType.getMenuType(new RandomRecommender().pickNumber());
        if (hasMinMenuType(menuTypes, menuType)) {
            return menuType;
        }
        return pickMenuCategory(menuTypes);
    }

    private static <T> boolean hasMinMenuType(List<T> list, T targetValue) {
        Map<T, Long> counts = list.stream()
                .filter(value -> value.equals(targetValue))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return counts.getOrDefault(targetValue, 0L) < MIN_MENU_TYPE_DUPLICATION;
    }

    private <T> T receiveValidatedInput(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return receiveValidatedInput(inputSupplier);
        }
    }
}
