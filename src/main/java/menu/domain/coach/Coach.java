package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.domain.coach.dto.RecommendDto;
import menu.domain.recommender.RandomRecommender;

public class Coach {

    private final String name;

    private List<String> recommendFoods;
    private final List<String> hateFoods;

    public Coach(String name, List<String> hateFoods) {
        this.name = name;
        this.recommendFoods = new ArrayList<>();
        this.hateFoods = hateFoods;
    }

    public void recommendFood(List<String> recommendMenus) {
        String menuName;
        do {
            menuName = new RandomRecommender().pickFromShuffleList(recommendMenus);
        } while (hateFoods.contains(menuName) || recommendFoods.contains(menuName));

        recommendFoods.add(menuName);
    }

    public RecommendDto getTotalRecommend() {
        return new RecommendDto(name, recommendFoods);
    }
}
