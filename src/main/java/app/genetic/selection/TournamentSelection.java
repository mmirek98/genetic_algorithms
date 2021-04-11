package app.genetic.selection;

import app.genetic.core.Population;

import java.util.Collections;

public class TournamentSelection implements SelectionStrategy{

    private final double chromosomesInTeam;

    public TournamentSelection(double chromosomesInTeam) {
        this.chromosomesInTeam = chromosomesInTeam;
    }

    public Population make(Population population) {
        Population newPopulation = new Population(population);
        Population team = new Population(population);
        while(population.getPopulationSize() != 0) {
            for(int i = 0; i < chromosomesInTeam; i++) {
                int rand = (int) (Math.random() * (population.getPopulationSize()));
                team.addElement(population.getElement(rand));
                population.removeElement(rand);
                if(population.getPopulationSize() == 0) {
                    break;
                }
            }

            Collections.sort(team.getPopulation());
            newPopulation.addElement(team.getLastElement());
            team.clearPopulation();
        }

        return newPopulation;
    }
}
