import java.util.ArrayList;
import java.util.Collections;

public class Elite {
    private final int eliteElementsCount;
    ArrayList<Element> eliteElements;
    public Elite(int eliteElementsCount) {
        eliteElements = new ArrayList<>();
        this.eliteElementsCount = eliteElementsCount;
    }

    public Population setEliteElements(Population population) {
        Population population1 = new Population(population);

        Collections.sort(population.getPopulation());
        int maxPopulSize = population.getPopulationSize() - 1;
        for(int i = maxPopulSize; i > maxPopulSize - eliteElementsCount; i--) {
            eliteElements.add(population.getElement(i));
            population.removeElement(population.getPopulationSize() - 1);
        }

        int max = population.getPopulationSize();
        for(int i = 0; i < max; i++) {
            int rand = (int) (Math.random() * (population.getPopulationSize()));
            population1.addElement(population.getElement(rand));
            population.removeElement(rand);
        }
        return population1;
    }

    public Population make(Population population) {
        returnEliteElements(population);
        return setEliteElements(population);
    }

    public void returnEliteElements(Population population) {
        for(int i = 0; i < eliteElementsCount; i++) {
            int rand = (int) (Math.random() * (eliteElements.size()));
            population.addElement(eliteElements.get(rand));
            eliteElements.remove(rand);
        }
    }
}
