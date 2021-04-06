package sample.genetic.core;

import java.util.Collections;

public class TournamentSelection implements SelectionStrategy{

    private final double chromosomesInTeam;

    public TournamentSelection(double chromosomesInTeam) {
        this.chromosomesInTeam = chromosomesInTeam;
    }

    void printOldPopulation(Population population) {
        System.out.println("rozmiar starej populacji: " + population.getPopulationSize());
        System.out.println("stara populacja");
        for(int i = 0; i < population.getPopulationSize(); i++) {
            System.out.println(population.getElement(i).getGrade());
        }
    }

    void printNewPopulation(Population population) {
        System.out.println("nowa populacja");
        for(int i = 0; i < population.getPopulationSize(); i++) {
            System.out.println(population.getElement(i).getGrade());
        }
        System.out.println("rozmiar nowej populacji: " + population.getPopulationSize());
    }


    public Population make(Population population) {
        //printOldPopulation(population);
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
//            System.out.println("Taka ekipa");
//            for(int i = 0; i < team.getPopulationSize(); i++) {
//                System.out.println(team.getElement(i).getGrade() + " prawdziwa liczba " + team.getRealNumber(i));
//            }
            Collections.sort(team.getPopulation());
            newPopulation.addElement(team.getLastElement());
            team.clearPopulation();
        }

        //printNewPopulation(newPopulation);
        return newPopulation;
    }
}
