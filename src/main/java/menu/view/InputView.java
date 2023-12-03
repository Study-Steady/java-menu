package menu.view;


import menu.view.printer.Printer;
import menu.view.reader.Reader;
import menu.view.validator.InputValidator;

public class InputView {
    private final Reader reader;
    private final Printer printer;

    private InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer);
    }

    public String inputTemplate() {
        printer.printLine("");
        String template = reader.readLine();
//        InputValidator.validate(template, "템플릿");
        return template;
    }
}
