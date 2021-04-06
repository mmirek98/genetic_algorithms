public class MinimalGrade implements GradeStrategy{
    public void makeGrades(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i++) {
            population.getElement(i).setGrade(1/Math.pow(population.getFirstChromosomeRealNumber(i), 2));
        }
    }
}
