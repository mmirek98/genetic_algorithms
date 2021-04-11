package app.genetic.mutation;

import app.genetic.core.Population;

public class OnePointMutation implements MutationStrategy {
    private final double chance;

    public OnePointMutation(double chance) {
        this.chance = chance;
    }

    public Population make(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i++) {
            for(int k = 0; k < 2; k ++) {
                double mutationChance = Math.random();
                if (mutationChance <= chance) {
                    int mutationPoint = (int) (Math.random() * (population.getChromosomeSize()));
                    String str = population.getElement(i).getChromosome(k);
                    String substr1 = str.substring(0, mutationPoint);
                    String substr2 = str.substring(mutationPoint + 1);
                    if (str.charAt(mutationPoint) == '1') {
                        population.getElement(i).setChromosome(substr1 + '0' + substr2, k);
                    } else {
                        population.getElement(i).setChromosome(substr1 + '1' + substr2, k);
                    }
                }
            }
        }
        return population;
    }
}
