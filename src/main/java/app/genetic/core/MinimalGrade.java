package app.genetic.core;

public class MinimalGrade implements GradeStrategy{
    public void makeGrades(Population population) {
        double min = 1;
        for(int i = 0; i < population.getPopulationSize(); i++) {
            population.getElement(i).setGrade(Math.pow(population.getFirstChromosomeRealNumber(i), 2) + Math.pow(population.getSecondChromosomeRealNumber(i), 2));
            if(population.getElement(i).getGrade() < min) {
                min = population.getElement(i).getGrade();
            }
        }
        if(min <= 0) {
            for(int i = 0; i < population.getPopulationSize(); i++) {
                population.getElement(i).setGrade((population.getElement(i).getGrade() - min) + 1);
            }
        }
        for(int i = 0; i < population.getPopulationSize(); i++) {
            population.getElement(i).setGrade(1/population.getElement(i).getGrade());
        }
    }
}
