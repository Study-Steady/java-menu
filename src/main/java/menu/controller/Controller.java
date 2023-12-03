package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachName;
import menu.domain.coach.Coaches;
import menu.domain.coach.RestrictedMenu;
import menu.domain.menu.Menu;
import menu.domain.recommend.MenuRecommender;
import menu.domain.recommend.category.MenuCategoryPicker;
import menu.domain.recommend.category.SystemRandomMenuCategoryPicker;
import menu.domain.recommend.menu.MenuPicker;
import menu.domain.recommend.menu.SystemRandomMenuNamePicker;
import menu.view.input.InputView;
import menu.view.output.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        welcomePlayer();

        Coaches coaches = inputCoaches();

        MenuRecommender recommender = setUpMenuRecommender(coaches);

        showRecommendResult(recommender);
    }

    private MenuRecommender setUpMenuRecommender(Coaches coaches) {
        return new MenuRecommender(
                new MenuCategoryPicker(new SystemRandomMenuCategoryPicker()),
                new MenuPicker(new SystemRandomMenuNamePicker()),
                coaches
        );
    }

    private void showRecommendResult(MenuRecommender recommender) {
        outputView.showMenuRecommendResult(recommender.recommend());
    }

    private Coaches inputCoaches() {
        return input(() -> {
            List<CoachName> coachNames = CoachName.namesOf(inputView.inputCoachNames());

            List<Coach> coaches = new ArrayList<>();

            for (CoachName name : coachNames) {
                List<Menu> restrictedMenuList = inputRestrictedMenu(name);
                coaches.add(new Coach(name, RestrictedMenu.from(restrictedMenuList)));
            }

            return Coaches.from(coaches);
        });
    }

    private List<Menu> inputRestrictedMenu(CoachName name) {
        return input(() -> Menu.namesOf(inputView.inputRestrictedMenu(name.getName())));
    }

    private void welcomePlayer() {
        outputView.welcomePlayer();
    }

    private <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return input(supplier);
        }
    }

}
