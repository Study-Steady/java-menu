package menu.domain;

import java.util.List;

public class AvoidedMenus {
    private final List<String> avoidedMenus;

    public AvoidedMenus(List<String> avoidedMenus) {
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
        return avoidedMenus.size() >= 0 && avoidedMenus.size() <= 2;
    }
}
