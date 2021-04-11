package app.genetic.grade;

import app.genetic.core.Population;
import app.genetic.function.Function;

public abstract class GradeStrategy {
    protected Function functionToOptimize;
    GradeStrategy(Function function) {
        this.functionToOptimize = function;
    }
    public void makeGrades(Population population) {};
}
