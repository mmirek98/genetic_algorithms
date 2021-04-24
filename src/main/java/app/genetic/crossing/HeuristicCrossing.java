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
        while(newPopulation.getPopulationSize() < population.getBasePopulationSize()) {
            double k = Math.random();
            int firstParent = (int) (Math.random() * (population.getPopulationSize()));
            int secondParent = (int) (Math.random() * (population.getPopulationSize()));
            double crossingChance = Math.random();
            double x1 = population.getElement(firstParent).getGene(0);
            double y1 = population.getElement(firstParent).getGene(1);
            double x2 = population.getElement(secondParent).getGene(0);
            double y2 = population.getElement(secondParent).getGene(1);
            double firstParentGrade = population.getElement(firstParent).getGrade();
            double secondParentGrade = population.getElement(secondParent).getGrade();
            if (secondParentGrade >= firstParentGrade){
                if (crossingChance <= chance) {
                    double x1new = k * (x2 - x1) + x2;
                    double y1new = k * (y2 - y1) + y2;
                    int checker = 0;
                    while(!(population.checkRange(x1new) && population.checkRange(y1new))) {
                        k = Math.random();
                        x1new = k * (x2 - x1) + x2;
                        y1new = k * (y2 - y1) + y2;
                        checker+=1;
                        if(checker > 10) {
                            break;
                        }
                    }
                    if(checker < 10) {
                        Element firstChild = new Element(x1new, y1new, 0);
                        newPopulation.addElement(firstChild);
                    }
                }
            }
        }
        return newPopulation;
    }
}
