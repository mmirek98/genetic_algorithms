package app.genetic.core;

import app.genetic.crossing.CrossingStrategy;
import app.genetic.elite.Elite;
import app.genetic.function.Function;
import app.genetic.grade.GradeStrategy;
import app.genetic.inversion.Inversion;
import app.genetic.mutation.MutationStrategy;
import app.genetic.selection.SelectionStrategy;
import app.view.PlotData;

public class Algorithm {
    Function functionToOptimize;

    public Algorithm(Function functionToOptimize) {
        this.functionToOptimize = functionToOptimize;
    }

    public void setNumberOfEpochs(int numberOfEpochs) {
        this.numberOfEpochs = numberOfEpochs;
    }

    public void makeAlgorithm(Population population, CrossingStrategy crossing, GradeStrategy grade, MutationStrategy mutation, SelectionStrategy selection, Inversion inversion, Elite elite) {
        grade.makeGrades(population);
        population = elite.setEliteElements(population);
        for(int i = 0; i < numberOfEpochs; i++) {
            elite.returnEliteElements(population);
            PlotData.setParams(population);
            population = elite.setEliteElements(population);
            population = selection.make(population);
            population = crossing.make(population);
            mutation.make(population);
            inversion.make(population);
            grade.makeGrades(population);
        }
        elite.returnEliteElements(population);
        setWinner(population);
    }

    void setWinner(Population population) {
        int maxIt = 0;
        double max = population.getElement(0).getGrade();
        for(int i = 0; i < population.getPopulationSize(); i++) {
            if(population.getElement(i).getGrade() > max) {
                maxIt = i;
                max = population.getElement(i).getGrade();
            }
        }
        winner = this.functionToOptimize.calculate(
                population.getFirstChromosomeRealNumber(maxIt),
                population.getSecondChromosomeRealNumber(maxIt));
    }

    public double getWinner() { return winner; }

    private int numberOfEpochs;
    private double winner;
}
