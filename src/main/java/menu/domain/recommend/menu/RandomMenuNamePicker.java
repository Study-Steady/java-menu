package menu.domain.recommend.menu;

import java.util.List;
import menu.domain.menu.Menu;

public interface RandomMenuNamePicker {

    String pick(List<String> menuNames);

}
