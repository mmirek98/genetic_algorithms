package app.genetic.crossing;

import app.genetic.core.Element;
import app.genetic.core.Population;

import java.util.ArrayList;
import java.util.List;

public class HomogeneousCrossing implements CrossingStrategy{
    private final double chance;

    public HomogeneousCrossing(double chance) {
        this.chance = chance;
    }

    public Population make(Population population) {
        Population newPopulation = new Population(population);
        while(newPopulation.getPopulationSize() < population.getBasePopulationSize()) {
            int firstParent = (int) (Math.random() * (population.getPopulationSize()));
            int secondParent = (int) (Math.random() * (population.getPopulationSize()));
            double crossingChance = Math.random();
            if(crossingChance <= chance) {
                List<String> firstChromosomes = new ArrayList<>();
                List<String> secondChromosomes = new ArrayList<>();
                for(int k = 0; k < 2; k++) {
                    String firstChildChromosome = "";
                    String secondChildChromosome = "";
                    for (int i = 1; i < population.getChromosomeSize(); i += 2) {
                        firstChildChromosome += population.getElement(firstParent).getChromosome(k).charAt(i - 1);
                        firstChildChromosome += population.getElement(secondParent).getChromosome(k).charAt(i);
                        secondChildChromosome += population.getElement(secondParent).getChromosome(k).charAt(i - 1);
                        secondChildChromosome += population.getElement(firstParent).getChromosome(k).charAt(i);
                    }
                    if (population.getChromosomeSize() % 2 != 0) {
                        int lastGeneIndex = population.getChromosomeSize() - 1;
                        firstChildChromosome += population.getElement(firstParent).getChromosome(k).charAt(lastGeneIndex);
                        secondChildChromosome += population.getElement(secondParent).getChromosome(k).charAt(lastGeneIndex);
                    }
                    firstChromosomes.add(firstChildChromosome);
                    secondChromosomes.add(secondChildChromosome);
                }
                Element firstChild = new Element(firstChromosomes.get(0), firstChromosomes.get(1), 0);
                Element secondChild = new Element(secondChromosomes.get(0), secondChromosomes.get(1), 0);
                newPopulation.addElement(firstChild);
                newPopulation.addElement(secondChild);
            }
        }
        return newPopulation;
    }
}
