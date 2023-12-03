package menu.domain;

import java.util.List;

public class AvoidedMenus {
    public static final int MAX_AVOIDEDE_MENUS_COUNT = 2;
    public static final int MIN_AVOIDEDE_MENUS_COUNT = 0;
    private final List<String> avoidedMenus;

    private AvoidedMenus(List<String> avoidedMenus) {
        validateCount(avoidedMenus);
        this.avoidedMenus = avoidedMenus;
    }

    public static AvoidedMenus from(List<String> avoidedMenus) {
        return new AvoidedMenus(avoidedMenus);
    }

    private void validateCount(List<String> avoidedMenus) {
        if (!isValidCount(avoidedMenus)) {
            throw new IllegalArgumentException("못 먹는 음식은 0~2개사이로 입력해야합니다.");
        }
    }

    private boolean isValidCount(List<String> avoidedMenus) {
        return avoidedMenus.size() >= MIN_AVOIDEDE_MENUS_COUNT && avoidedMenus.size() <= MAX_AVOIDEDE_MENUS_COUNT;
    }

    public boolean contains(Menu menu) {
        return avoidedMenus.stream()
                .anyMatch(menu::isSameMenu);
    }
}
