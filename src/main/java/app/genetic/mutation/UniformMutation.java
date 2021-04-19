package app.genetic.mutation;

import app.genetic.core.Population;
import org.decimal4j.util.DoubleRounder;

public class UniformMutation implements MutationStrategy{
    private final double chance;

    public UniformMutation(double chance) {
        this.chance = chance;
    }
    @Override
    public void make(Population population) {
        double rightBoundary = population.getRightBoundary();
        double leftBoundary = population.getLeftBoundary();
        int geneAccuracy = population.getGeneAccuracy();
        for(int i = 0; i < population.getPopulationSize(); i++) {
            double mutationChance = Math.random();
            if (mutationChance <= chance) {
                int mutatedElement = (int) DoubleRounder.round(Math.random(), 0);
                double gene = DoubleRounder.round((Math.random() * (rightBoundary - leftBoundary)) + leftBoundary, geneAccuracy);
                population.getElement(i).setGene(gene, mutatedElement);
            }
        }
    }
}
