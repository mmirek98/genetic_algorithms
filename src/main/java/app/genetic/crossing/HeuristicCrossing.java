package app.genetic.crossing;

import app.genetic.core.Element;
import app.genetic.core.Population;

public class HeuristicCrossing implements CrossingStrategy{

    private final double chance;

    public HeuristicCrossing(double chance) {
        this.chance = chance;
    }

    @Override
    public Population make(Population population) {
        Population newPopulation = new Population(population);
        double k = Math.random();
        while(newPopulation.getPopulationSize() < population.getBasePopulationSize()) {
            int firstParent = (int) (Math.random() * (population.getPopulationSize()));
            int secondParent = (int) (Math.random() * (population.getPopulationSize()));
            double crossingChance = Math.random();
            double x1 = population.getElement(firstParent).getGene(0);
            double y1 = population.getElement(firstParent).getGene(1);
            double x2 = population.getElement(secondParent).getGene(0);
            double y2 = population.getElement(secondParent).getGene(1);

            if (x2 > x1 && y2 > y1){
                if (crossingChance <= chance) {
                    double x1new = k * (x2 - x1) + x1;
                    double y1new = k * (y2 - y1) + y1;

                    Element firstChild = new Element(x1new, y1new, 0);
                    newPopulation.addElement(firstChild);
                }
            }
        }
        return newPopulation;
    }
}
