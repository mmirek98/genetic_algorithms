package app.genetic.core;

import org.decimal4j.util.DoubleRounder;
import java.util.ArrayList;
import java.util.List;

public class Population {

    public Population(int populationSize, int chromosomeAccuracy, double leftBoundary, double rightBoundary, int eliteElements) {
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
        population = new ArrayList<>();
        String chromosome = "";
        double range = (rightBoundary-leftBoundary) * Math.pow(10, chromosomeAccuracy);
        chromosomeSize = (int) (log2(range)) + 1;

        for(int i = 0; i < populationSize; i++){
            List<String> chromosomes = new ArrayList<>();
            for(int k = 0; k < 2; k++) {
                for(int j = 0; j < chromosomeSize; j++) {
                    double gene = DoubleRounder.round(Math.random(), 0);
                    chromosome += String.valueOf((int) gene);
                }
                chromosomes.add(chromosome);
                chromosome = "";
            }
            population.add(new Element(chromosomes.get(0),chromosomes.get(1), 0));
        }
        this.populationSize = populationSize;
        this.basePopulationSize = populationSize - eliteElements;
        this.chromosomeAccuracy = chromosomeAccuracy;
    }

    public Population(Population populationOld) {
        this.population = new ArrayList<>();
        this.populationSize = 0;
        this.basePopulationSize = populationOld.basePopulationSize;
        this.chromosomeAccuracy = populationOld.getChromosomeAccuracy();
        this.leftBoundary = populationOld.getLeftBoundary();
        this.rightBoundary = populationOld.getRightBoundary();
        double range = (rightBoundary-leftBoundary) * Math.pow(10, chromosomeAccuracy);
        chromosomeSize = (int) (log2(range)) + 1;
    }

    public ArrayList<Element> getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList<Element> population) {
        this.population = population;
    }

    public Element getLastElement() {
        return population.get(population.size() - 1);
    }

    public int getBasePopulationSize() {
        return this.basePopulationSize;
    }

    public void clearPopulation() {
        population.clear();
        populationSize = 0;
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

    public double getFirstChromosomeRealNumber(int i) {
        double range = rightBoundary - leftBoundary;
        String str = population.get(i).getChromosome(0);
        double doo = 0;
        for (int j = 0; j < str.length(); j++) {

            if (str.charAt(j) == '1') {
                int len = str.length() - 1 - j;
                doo += Math.pow(2, len);
            }
        }
        int obl1 = (int) doo;
        double summary = leftBoundary + obl1 * range / (Math.pow(2, chromosomeSize) - 1);
        //double summary = leftBoundary + Integer.parseInt(population.get(i).getChromosome(0), 2) * range / (Math.pow(2, chromosomeSize) - 1);
        return DoubleRounder.round(summary, chromosomeAccuracy);
    }

    public double getSecondChromosomeRealNumber(int i) {
        double range = rightBoundary - leftBoundary;
        String str = population.get(i).getChromosome(1);
        double doo = 0;
        for (int j = 0; j < str.length(); j++) {

            if (str.charAt(j) == '1') {
                int len = str.length() - 1 - j;
                doo += Math.pow(2, len);
            }
        }
        int obl1 = (int) doo;
        double summary = leftBoundary + obl1 * range / (Math.pow(2, chromosomeSize) - 1);
        //double summary = leftBoundary + Integer.parseInt(population.get(i).getChromosome(1), 2) * range / (Math.pow(2, chromosomeSize) - 1);
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

    public double getLeftBoundary() { return leftBoundary; }

    public double getRightBoundary() { return rightBoundary; }

    private ArrayList<Element> population;
    private int populationSize;
    private final int basePopulationSize;
    private final int chromosomeSize;
    private final double leftBoundary;
    private final double rightBoundary;
    private final int chromosomeAccuracy;
}