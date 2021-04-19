package app.genetic.grade;

import app.genetic.core.Population;
import app.genetic.function.Function;

public class MinimalGrade extends GradeStrategy {
    public MinimalGrade(Function function) {
        super(function);
    }

    public void makeGrades(Population population) {
        double min = 1;
        for(int i = 0; i < population.getPopulationSize(); i++) {
            population.getElement(i).setGrade(
                    functionToOptimize.calculate(
                            population.getElement(i).getGene(0),
                            population.getElement(i).getGene(1)
                    )
            );
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
