package sample.genetic.core;

import java.util.ArrayList;
import java.util.List;

public class TwoPointsCrossing implements CrossingStrategy{
    private final double chance;

    TwoPointsCrossing(double chance) {
        this.chance = chance;
    }

    void printOldPopulation(Population population) {
        System.out.println("rozmiar starej populacji: " + population.getPopulationSize());
        System.out.println("stara populacja");
        for(int i = 0; i < population.getPopulationSize(); i++) {
            System.out.println(population.getElement(i).getChromosome(0));
        }
    }

    void printNewPopulation(Population population) {
        System.out.println("nowa populacja");
        for(int i = 0; i < population.getPopulationSize(); i++) {
            System.out.println(population.getElement(i).getChromosome(0));
        }
        System.out.println("rozmiar nowej populacji: " + population.getPopulationSize());
    }

    public Population make(Population population) {
        Population newPopulation = new Population(population);
        printOldPopulation(population);
        while(newPopulation.getPopulationSize() < population.getPopulationSize()) {
            int firstParent = (int) (Math.random() * (population.getPopulationSize()));
            int secondParent = (int) (Math.random() * (population.getPopulationSize()));
            double crossingChance = Math.random();
            if(crossingChance <= chance) {
                List<String> firstChromosomes = new ArrayList<>();
                List<String> secondChromosomes = new ArrayList<>();

                for(int k = 0; k < 2; k++) {
                    int crossingPoint0;
                    int crossingPoint1;
                    do {
                        crossingPoint0 = (int) (Math.random() * (population.getChromosomeSize()));
                        crossingPoint1 = (int) (Math.random() * (population.getChromosomeSize()));
                    } while(crossingPoint0 == crossingPoint1);

                    int firstPoint;
                    int secondPoint;
                    if(crossingPoint0 > crossingPoint1) {
                        firstPoint = crossingPoint1;
                        secondPoint = crossingPoint0;
                    } else {
                        firstPoint = crossingPoint0;
                        secondPoint = crossingPoint1;
                    }

                    String firstPart0 = population.getElement(firstParent).getChromosome(k).substring(0, firstPoint + 1);
                    String secondPart0 = population.getElement(secondParent).getChromosome(k).substring(firstPoint + 1, secondPoint + 1);
                    String thirdPart0 = population.getElement(firstParent).getChromosome(k).substring(secondPoint + 1);

                    String firstPart1 = population.getElement(secondParent).getChromosome(k).substring(0, firstPoint + 1);
                    String secondPart1 = population.getElement(firstParent).getChromosome(k).substring(firstPoint + 1, secondPoint + 1);
                    String thirdPart1 = population.getElement(secondParent).getChromosome(k).substring(secondPoint + 1);

                    firstChromosomes.add(firstPart0 + secondPart0 + thirdPart0);
                    secondChromosomes.add(firstPart1 + secondPart1 + thirdPart1);
                }
                Element firstChild = new Element(firstChromosomes.get(0), firstChromosomes.get(1), 0);
                Element secondChild = new Element(secondChromosomes.get(0), secondChromosomes.get(1), 0);
                newPopulation.addElement(firstChild);
                newPopulation.addElement(secondChild);
            }
        }
        printNewPopulation(newPopulation);
        return newPopulation;
    }
}
