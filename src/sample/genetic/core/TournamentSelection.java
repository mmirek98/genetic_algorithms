package sample.genetic.core;

public class TournamentSelection implements SelectionStrategy{
    public Population make(Population population) {
        System.out.println("tournament selection\n");
        return population;
    }
}
