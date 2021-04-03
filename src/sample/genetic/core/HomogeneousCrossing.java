package sample.genetic.core;

import java.util.ArrayList;

public class HomogeneousCrossing implements CrossingStrategy{
    private double chance;

    HomogeneousCrossing(double chance) {
        this.chance = chance;
    }

    public Population make(Population population) {
        System.out.println("homogenouscrossing\n");
        return population;
    }
}
