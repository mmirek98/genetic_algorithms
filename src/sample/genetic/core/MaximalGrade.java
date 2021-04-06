package sample.genetic.core;

public class MaximalGrade implements GradeStrategy{
    public void makeGrades(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i++) {
            population.getElement(i).setGrade(Math.pow(population.getFirstChromosomeRealNumber(i), 2) + Math.pow(population.getSecondChromosomeRealNumber(i), 2));
        }
    }
}
