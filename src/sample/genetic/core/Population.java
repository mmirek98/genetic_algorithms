package sample.genetic.core;

import org.decimal4j.util.DoubleRounder;
import java.util.ArrayList;

public class Population {

    public Population(int populationSize, int chromosomeAccuracy) {
        population = new ArrayList<>();
        StringBuilder chromosome = new StringBuilder();
        double range = (rightBoundary-leftBoundary) * Math.pow(10, chromosomeAccuracy);
        chromosomeSize = (int) (log2(range)) + 1;

        for(int i = 0; i < populationSize; i++){
            for(int j = 0; j < chromosomeSize; j++) {
                double gene = DoubleRounder.round(Math.random(), 0);
                chromosome.append(String.valueOf((int) gene));
            }
            population.add(new Element(chromosome.toString(),0));
            chromosome = new StringBuilder();
        }
        this.populationSize = populationSize;
        this.chromosomeAccuracy = chromosomeAccuracy;
    }

    public ArrayList<Element> getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList<Element> population) {
        this.population = population;
    }

    public void addElement(Element element) {
        population.add(element);
        populationSize++;
    }

    public void removeElement(int i) {
        population.remove(i);
        populationSize--;
    }

    double log2(double N)
    {
        return (Math.log(N) / Math.log(2));
    }

    public double getRealNumber(int i) {
        int range = rightBoundary - leftBoundary;
        double summary = leftBoundary + Integer.parseInt(population.get(i).getChromosome(), 2) * range / (Math.pow(2, chromosomeSize) - 1);
        return DoubleRounder.round(summary, chromosomeAccuracy);
    }

    public Element getElement(int i) {
        return population.get(i);
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getChromosomeSize() { return chromosomeSize; }

    public int getChromosomeAccuracy() {
        return chromosomeAccuracy;
    }

    ArrayList<Element> population;
    int populationSize;
    int chromosomeSize;
    int leftBoundary = -10;
    int rightBoundary = 10;
    private final int chromosomeAccuracy;
}