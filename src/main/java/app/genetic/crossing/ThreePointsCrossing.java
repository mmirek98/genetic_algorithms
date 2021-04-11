package app.genetic.crossing;

import app.genetic.core.Element;
import app.genetic.core.Population;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ThreePointsCrossing implements CrossingStrategy {
    private final double chance;

    public ThreePointsCrossing(double chance) {
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
                for (int k = 0; k < 2; k++) {
                    Set<Integer> crossingPointsSet = new TreeSet<>();
                    do {
                        crossingPointsSet.add((int) (Math.random() * (population.getChromosomeSize())));
                    } while(crossingPointsSet.size() != 3);

                    ArrayList<Integer> crossingPoints = new ArrayList<>(crossingPointsSet);

                    String firstPart0 = population.getElement(firstParent).getChromosome(k).substring(0, crossingPoints.get(0) + 1);
                    String secondPart0 = population.getElement(secondParent).getChromosome(k).substring(crossingPoints.get(0) + 1, crossingPoints.get(1) + 1);
                    String thirdPart0 = population.getElement(firstParent).getChromosome(k).substring(crossingPoints.get(1) + 1, crossingPoints.get(2) + 1);
                    String fourthPart0 = population.getElement(secondParent).getChromosome(k).substring(crossingPoints.get(2) + 1);

                    String firstPart1 = population.getElement(secondParent).getChromosome(k).substring(0, crossingPoints.get(0) + 1);
                    String secondPart1 = population.getElement(firstParent).getChromosome(k).substring(crossingPoints.get(0) + 1, crossingPoints.get(1) + 1);
                    String thirdPart1 = population.getElement(secondParent).getChromosome(k).substring(crossingPoints.get(1) + 1, crossingPoints.get(2) + 1);
                    String fourthPart1 = population.getElement(secondParent).getChromosome(k).substring(crossingPoints.get(2) + 1);

                    firstChromosomes.add(firstPart0 + secondPart0 + thirdPart0 + fourthPart0);
                    secondChromosomes.add(firstPart1 + secondPart1 + thirdPart1 + fourthPart1);
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
