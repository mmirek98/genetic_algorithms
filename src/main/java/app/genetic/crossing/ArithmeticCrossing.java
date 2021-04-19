package app.genetic.crossing;

import app.genetic.core.Element;
import app.genetic.core.Population;


public class ArithmeticCrossing implements CrossingStrategy{
    private final double chance;
    public ArithmeticCrossing(double chance) {
        this.chance = chance;
    }
    public Population make(Population population) {
        Population newPopulation = new Population(population);
        double k = Math.random();
        while(newPopulation.getPopulationSize() < population.getBasePopulationSize()) {
            int firstParent = (int) (Math.random() * (population.getPopulationSize()));
            int secondParent = (int) (Math.random() * (population.getPopulationSize()));
            double crossingChance = Math.random();
            if(crossingChance <= chance) {
                double x1 = population.getElement(firstParent).getGene(0);
                double y1 = population.getElement(firstParent).getGene(1);
                double x2 = population.getElement(secondParent).getGene(0);
                double y2 = population.getElement(secondParent).getGene(1);

                double x1new = k * x1 + (1 - k) * x2;
                double y1new = k * y1 + (1 - k) * y2;
                double x2new = (1 - k) * x1 + k * x2;
                double y2new = (1 - k) * y1 + k * y2;

                Element firstChild = new Element(x1new, y1new, 0);
                Element secondChild = new Element(x2new, y2new, 0);
                newPopulation.addElement(firstChild);
                newPopulation.addElement(secondChild);
            }
        }
        return newPopulation;
    }
}
