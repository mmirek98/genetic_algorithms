
public class EdgeMutation implements MutationStrategy{
    private final double chance;

    EdgeMutation(double chance) {
        this.chance = chance;
    }

    public Population make(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i++) {
            for (int k = 0; k < 2; k++) {
                double mutationChance = Math.random();
                if (mutationChance <= chance) {
                    String str = population.getElement(i).getChromosome(k);
                    String substring = str.substring(0, str.length() - 1);
                    if (str.charAt(str.length() - 1) == '1') {
                        population.getElement(i).setChromosome(substring + '0', k);
                    } else {
                        population.getElement(i).setChromosome(substring + '1', k);
                    }
                }
            }
        }
        return population;
    }
}
