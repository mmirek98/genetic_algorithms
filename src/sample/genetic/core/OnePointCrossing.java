import java.util.ArrayList;
import java.util.List;

public class OnePointCrossing implements CrossingStrategy{
    private final double chance;

    OnePointCrossing(double chance) {
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
        while(newPopulation.getPopulationSize() < population.getPopulationSize()) {
            int firstParent = (int) (Math.random() * (population.getPopulationSize()));
            int secondParent = (int) (Math.random() * (population.getPopulationSize()));
            double crossingChance = Math.random();
            if(crossingChance <= chance) {
                List<String> firstChromosomes = new ArrayList<>();
                List<String> secondChromosomes = new ArrayList<>();
                for(int k = 0; k < 2; k++) {
                    int crossingPoint = (int) (Math.random() * (population.getChromosomeSize()));
                    String firstPart0 = population.getElement(firstParent).getChromosome(k).substring(0, crossingPoint + 1);
                    String secondPart0 = population.getElement(secondParent).getChromosome(k).substring(crossingPoint + 1);
                    String firstPart1 = population.getElement(secondParent).getChromosome(k).substring(0, crossingPoint + 1);
                    String secondPart1 = population.getElement(firstParent).getChromosome(k).substring(crossingPoint + 1);
                    firstChromosomes.add(firstPart0 + secondPart0);
                    secondChromosomes.add(firstPart1 + secondPart1);
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
