package app.genetic.core;

public class RouletteSelection implements SelectionStrategy{
    public Population make(Population population) {
        Population population1 = new Population(population);
        double sum = 0;
        double max = 0;

        for(int i = 0; i < population.getPopulationSize(); i++) {
            max += population.getElement(i).getGrade();
        }
        for(int i = 0; i < population.getPopulationSize(); i++) {
            double rand = Math.random() * (max + 1);
            for(int j = 0; j < population.getPopulationSize(); j++) {
                sum += population.getElement(j).getGrade();
                if(sum > rand) {
                    population1.addElement(population.getElement(j));
                    break;
                }
            }
            sum = 0;
        }
        return population1;
    }
}
