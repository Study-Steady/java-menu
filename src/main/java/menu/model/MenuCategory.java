package menu.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public enum MenuCategory {
    JAPANESE("일식", 1, List.of(
            Menu.GYUDON, Menu.UDON, Menu.MISO_SOUP, Menu.SUSHI, Menu.KATSDON,
            Menu.ONIGIRI, Menu.HAYASHI_RICE, Menu.RAMEN, Menu.OKONOMIYAKI)),
    KOREAN("한식", 2, List.of(
            Menu.GIMBAP, Menu.KIMCHI_JJIGAE, Menu.SSAM_BAP, Menu.DOENJANG_JJIGAE, Menu.BIBIMBAP,
            Menu.KALGUKSU, Menu.BULGOGI, Menu.TTEOKBOKKI, Menu.JAEYUK_BOKKEUM)),
    CHINESE("중식", 3, List.of(
            Menu.KANPOONGGI, Menu.STIR_FRIED_NOODLES, Menu.DONGPO_PORK, Menu.JAJANGMYEON, Menu.JJAMPPONG,
            Menu.MAPO_TOFU, Menu.TANGSUYUK, Menu.TOMATO_EGG_STIR_FRY, Menu.JAPCHAE)),
    ASIAN("아시안", 4, List.of(
            Menu.PAD_THAI, Menu.KHAO_PHAT, Menu.NASI_GORENG, Menu.PINEAPPLE_FRIED_RICE, Menu.RICE_NOODLES,
            Menu.TOM_YUM_GOONG, Menu.BANH_MI, Menu.WOL_NAM_SAM, Menu.BUN_CHA)),
    WESTERN("양식", 5, List.of(
            Menu.LASAGNA, Menu.GRATIN, Menu.GNOCCHI, Menu.QUICHE, Menu.FRENCH_TOAST,
            Menu.BAGUETTE, Menu.SPAGHETTI, Menu.PIZZA, Menu.PANINI));

    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;

    private final String name;
    private final int categoryNumber;
    private final List<Menu> menus;

    MenuCategory(String name, int categoryNumber, List<Menu> menus) {
        this.name = name;
        this.categoryNumber = categoryNumber;
        this.menus = menus;
    }

    public static RecommendedMenuCategories recommendCategory(NumberGenerator numberGenerator) {
        List<MenuCategory> recommendedMenuCategory = getMenuCategories(numberGenerator);

        if (isOverRecommended(recommendedMenuCategory)) {
            return recommendCategory(numberGenerator);
        }

        return RecommendedMenuCategories.from(recommendedMenuCategory);
    }

    public void recommendMenusTo(Coaches coaches, Picker picker) {
        List<String> menuNames = getMenuNamesOf(menus);
        coaches.recommendMenus(menuNames, picker);
    }

    private List<String> getMenuNamesOf(List<Menu> menus) {
        return menus.stream()
                .map(Menu::getName)
                .toList();
    }

    private static List<MenuCategory> getMenuCategories(NumberGenerator numberGenerator) {
        return Stream.generate(() -> numberGenerator.generateBetween(MIN_CATEGORY_NUMBER, MAX_CATEGORY_NUMBER))
                .filter(categoryNumber -> categoryNumber >= MIN_CATEGORY_NUMBER
                        && categoryNumber <= MAX_CATEGORY_NUMBER)
                .limit(5)
                .map(MenuCategory::findCategoryByNumber)
                .toList();
    }

    private static boolean isOverRecommended(List<MenuCategory> recommendedMenuCategory) {
        for (MenuCategory menuCategory : MenuCategory.values()) {
            int frequency = Collections.frequency(recommendedMenuCategory, menuCategory);
            if (frequency > 2) {
                return true;
            }
        }
        return false;
    }

    private static MenuCategory findCategoryByNumber(int categoryNumber) {
        return Stream.of(MenuCategory.values())
                .filter(menuCategory -> menuCategory.categoryNumber == categoryNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    public String getName() {
        return name;
    }
}
