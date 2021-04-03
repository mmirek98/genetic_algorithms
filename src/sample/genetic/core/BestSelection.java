package sample.genetic.core;

public class BestSelection implements SelectionStrategy {
    public Population make(Population population) {
        System.out.println("bestselection\n");
        return population;
    }
}
