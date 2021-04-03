package sample.genetic.core;

public class TwoPointsCrossing implements CrossingStrategy{
    private double chance;

    TwoPointsCrossing(double chance) {
        this.chance = chance;
    }

    public Population make(Population population) {
        System.out.println("two points crossing\n");
        return population;
    }
}
