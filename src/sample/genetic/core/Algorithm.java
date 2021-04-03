package sample.genetic.core;

public class Algorithm {

    public void setNumberOfEpochs(int numberOfEpochs) {
        this.numberOfEpochs = numberOfEpochs;
    }

    public void makeAlgorithm(Population population, CrossingStrategy crossing, GradeStrategy grade, MutationStrategy mutation, SelectionStrategy selection, Inversion inversion, Elite elite) {
        grade.makeGrades(population);
        population = elite.setEliteElements(population);
//        for(int i = 0; i < population.getPopulationSize(); i ++) {
//            System.out.println("pierwsza populacyja: " + population.getRealNumber(i));
//        }
        for(int i = 0; i < numberOfEpochs; i++) {
            grade.makeGrades(population);
            population = elite.make(population);
            selection.make(population);
            crossing.make(population);
            mutation.make(population);
            inversion.make(population);
        }
        grade.makeGrades(population);
//        for(int i = 0; i < population.getPopulationSize(); i ++) {
//            System.out.println("populactyyyja bez elitusuf: " + population.getElement(i).getGrade());
//        }
        elite.returnEliteElements(population);
        setWinner(population);
//        for(int i = 0; i < population.getPopulationSize(); i ++) {
//            System.out.println("populactyyyja: " + population.getElement(i).getGrade());
//        }
//        for(int i = 0; i < population.getPopulationSize(); i ++) {
//            System.out.println("osdtatni el: " + population.getRealNumber(i));
//        }
    }

    void setWinner(Population population) {
        double max = population.getElement(0).getGrade();
        for(int i = 0; i < population.getPopulationSize(); i++) {
            if(population.getElement(i).getGrade() > max) {
                max = population.getElement(i).getGrade();
            }
        }
        winner = max;
    }

    public double getWinner() { return winner; }

    private int numberOfEpochs;
    private double winner;
}
