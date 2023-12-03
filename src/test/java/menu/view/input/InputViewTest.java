package menu.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import menu.mock.FakePrinter;
import menu.mock.FakeReader;
import menu.view.print.Printer;
import menu.view.read.Reader;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final Printer printer = new FakePrinter();

    @Test
    void inputCoachNames() {
        // given
        Reader reader = new FakeReader("1,1,1");
        InputView inputView = new InputView(reader, printer);

        // when
        List<String> result = inputView.inputCoachNames();

        // then
        assertThat(result).isEqualTo(List.of("1", "1", "1"));
    }

}