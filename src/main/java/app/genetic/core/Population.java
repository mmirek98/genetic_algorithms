package app.genetic.core;

import org.decimal4j.util.DoubleRounder;
import java.util.ArrayList;
import java.util.List;

public class Population {

    public Population(int populationSize, int geneAccuracy, double leftBoundary, double rightBoundary, int eliteElements) {
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
        population = new ArrayList<>();
        for(int i = 0; i < populationSize; i++){
            List<Double> genes = new ArrayList<>();
            for(int k = 0; k < 2; k++) {
                double gene = DoubleRounder.round((Math.random() * (rightBoundary - leftBoundary)) + leftBoundary, geneAccuracy);
                genes.add(gene);
            }
            population.add(new Element(genes.get(0),genes.get(1), 0));
        }
        this.populationSize = populationSize;
        this.basePopulationSize = populationSize - eliteElements;
        this.geneAccuracy = geneAccuracy;
    }

    public Population(Population populationOld) {
        this.population = new ArrayList<>();
        this.populationSize = 0;
        this.basePopulationSize = populationOld.basePopulationSize;
        this.geneAccuracy = populationOld.getGeneAccuracy();
        this.leftBoundary = populationOld.getLeftBoundary();
        this.rightBoundary = populationOld.getRightBoundary();
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

    public Element getElement(int i) {
        return population.get(i);
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getGeneAccuracy() {
        return geneAccuracy;
    }

    public double getLeftBoundary() { return leftBoundary; }

    public double getRightBoundary() { return rightBoundary; }

    private ArrayList<Element> population;
    private int populationSize;
    private final int basePopulationSize;
    private final double leftBoundary;
    private final double rightBoundary;
    private final int geneAccuracy;
}