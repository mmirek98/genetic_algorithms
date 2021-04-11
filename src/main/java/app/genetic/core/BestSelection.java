package app.genetic.core;

import java.util.Collections;


public class BestSelection implements SelectionStrategy {
    private final double percentOfSelectionElements;

    public BestSelection(double percentOfSelectionElements) {
        this.percentOfSelectionElements = percentOfSelectionElements;
    }

    public Population make(Population population) {
        Collections.sort(population.getPopulation());
        int selectionElements = (int) (population.getPopulationSize() * percentOfSelectionElements);
        int elementsToDelete = population.getPopulationSize() - selectionElements;
        for(int i = 0; i < elementsToDelete; i++) {
            population.removeElement(0);
        }
        return population;
    }
}
