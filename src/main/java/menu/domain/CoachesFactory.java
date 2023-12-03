//package menu.domain;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import menu.util.StringConvertor;
//import menu.view.ErrorView;
//
//public class CoachesFactory {
//    private final ErrorView errorView;
//
//    public CoachesFactory(ErrorView errorView) {
//        this.errorView = errorView;
//    }
//
//
////    public Coaches createCoachesBy(List<Coach>) {
////        try {
////            List<Coach> coaches = Arrays.stream(StringConvertor.splitByComma(inputCoaches))
////                    .map(Coach::from)
////                    .collect(Collectors.toUnmodifiableList());
////            return Coaches.from(coaches);
////        } catch (IllegalArgumentException exception) {
////            errorView.printErrorMessage(exception.getMessage());
////        }
////    }}
