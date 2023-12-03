package menu.model;

public enum Menu {
    // 일식
    GYUDON("규동"),
    UDON("우동"),
    MISO_SOUP("미소시루"),
    SUSHI("스시"),
    KATSDON("가츠동"),
    ONIGIRI("오니기리"),
    HAYASHI_RICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼"),

    // 한식
    GIMBAP("김밥"),
    KIMCHI_JJIGAE("김치찌개"),
    SSAM_BAP("쌈밥"),
    DOENJANG_JJIGAE("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JAEYUK_BOKKEUM("제육볶음"),

    // 중식
    KANPOONGGI("깐풍기"),
    STIR_FRIED_NOODLES("볶음면"),
    DONGPO_PORK("동파육"),
    JAJANGMYEON("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPO_TOFU("마파두부"),
    TANGSUYUK("탕수육"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음"),
    JAPCHAE("고추잡채"),

    // 아시안
    PAD_THAI("팟타이"),
    KHAO_PHAT("카오 팟"),
    NASI_GORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    RICE_NOODLES("쌀국수"),
    TOM_YUM_GOONG("똠얌꿍"),
    BANH_MI("반미"),
    WOL_NAM_SAM("월남삼"),
    BUN_CHA("분짜"),

    // 양식
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    GNOCCHI("뇨끼"),
    QUICHE("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private final String name;

    Menu(String name) {
        this.name = name;
    }

}

