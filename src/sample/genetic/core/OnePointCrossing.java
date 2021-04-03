package sample.genetic.core;

public class OnePointCrossing implements CrossingStrategy{
    private final double chance;

    OnePointCrossing(double chance) {
        this.chance = chance;
    }

    public Population make(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i+=2) {
            double crossingChance = Math.random();
            if(crossingChance <= chance) {
                int crossingPoint = (int) (Math.random() * (population.getChromosomeSize()));
                String firstPart0 = population.getElement(i).getChromosome().substring(0, crossingPoint + 1);
                String secondPart0 = population.getElement(i+1).getChromosome().substring(crossingPoint + 1);
                String firstPart1 = population.getElement(i+1).getChromosome().substring(0, crossingPoint + 1);
                String secondPart1 = population.getElement(i).getChromosome().substring(crossingPoint + 1);
                population.getElement(i).setChromosome(firstPart0+secondPart0);
                population.getElement(i+1).setChromosome(firstPart1+secondPart1);
            }
        }
        return population;
    }
}
