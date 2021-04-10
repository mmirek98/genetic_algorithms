package sample.genetic.core;

public class Algorithm {

    public void setNumberOfEpochs(int numberOfEpochs) {
        this.numberOfEpochs = numberOfEpochs;
    }

    public void makeAlgorithm(Population population, CrossingStrategy crossing, GradeStrategy grade, MutationStrategy mutation, SelectionStrategy selection, Inversion inversion, Elite elite) {
        grade.makeGrades(population);
        population = elite.setEliteElements(population);
        for(int i = 0; i < numberOfEpochs; i++) {
            population = elite.make(population);
            population = selection.make(population);
            population = crossing.make(population);
            mutation.make(population);
            inversion.make(population);
            grade.makeGrades(population);
        }
        elite.returnEliteElements(population);
        setWinner(population, grade);
    }

    void setWinner(Population population, GradeStrategy grade) {
        double max = population.getElement(0).getGrade();
        for(int i = 0; i < population.getPopulationSize(); i++) {
            if(population.getElement(i).getGrade() > max) {
                max = population.getElement(i).getGrade();
            }
        }
        winner = max;
        if(grade instanceof MinimalGrade) {
            winner = 1/winner;
        }
    }

    public double getWinner() { return winner; }

    private int numberOfEpochs;
    private double winner;
}
