package sample.genetic.core;

import java.util.ArrayList;

public class ThreePointsCrossing implements CrossingStrategy {
    private double chance;

    ThreePointsCrossing(double chance) {
        this.chance = chance;
    }

    public Population make(Population population) {
        System.out.println("three points crossing\n");
        return population;
    }
}
