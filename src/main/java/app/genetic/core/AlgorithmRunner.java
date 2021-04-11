package app.genetic.core;

import app.genetic.crossing.*;
import app.genetic.elite.Elite;
import app.genetic.function.BealeFunction;
import app.genetic.function.Function;
import app.genetic.grade.GradeStrategy;
import app.genetic.grade.MaximalGrade;
import app.genetic.grade.MinimalGrade;
import app.genetic.inversion.Inversion;
import app.genetic.mutation.EdgeMutation;
import app.genetic.mutation.MutationStrategy;
import app.genetic.mutation.OnePointMutation;
import app.genetic.mutation.TwoPointsMutation;
import app.genetic.selection.BestSelection;
import app.genetic.selection.RouletteSelection;
import app.genetic.selection.SelectionStrategy;
import app.genetic.selection.TournamentSelection;
import app.view.PlotData;

public class AlgorithmRunner {
    private SelectionStrategy selection;
    private MutationStrategy mutation;
    private CrossingStrategy crossing;
    private GradeStrategy grade;
    private Inversion inversion;
    private Elite elite;
    private long executionTime;
    private Function functionToOptimize = new BealeFunction();

    public double learn(AlgorithmAttributes attributes) {
        PlotData.clearPlotData();
        PlotData.setFunction(this.functionToOptimize);
        Algorithm algorithm = new Algorithm(this.functionToOptimize);
        Population population = new Population(attributes.getPopulationSize(), attributes.getChromosomeAccuracy(),
                attributes.getPopulationLeftBoundary(), attributes.getPopulationRightBoundary(), attributes.getEliteElements());
        algorithm.setNumberOfEpochs(attributes.getNumberOfEpochs());
        setCrossingStrategy(attributes.getCrossingStrategy(), attributes.getCrossingChance());
        setGradeStrategy(attributes.getGradeStrategy());
        setMutationStrategy(attributes.getMutationStrategy(), attributes.getMutationChance());
        setSelectionStrategy(attributes.getSelectionStrategy(), attributes.getSelectionParameter());
        inversion = new Inversion(attributes.getInversionChance());
        elite = new Elite(attributes.getEliteElements());
        long startExecution = System.currentTimeMillis();
        algorithm.makeAlgorithm(population, crossing, grade, mutation, selection, inversion, elite);
        executionTime = System.currentTimeMillis() - startExecution;
        return algorithm.getWinner();
    }

    public long getExecutionTime() {
        return executionTime;
    }

    private void setCrossingStrategy(StrategyEnums.CrossingOptions strategy, double chance) {
        switch (strategy) {
            case HOMOGENEOUS_CROSSING -> crossing = new HomogeneousCrossing(chance);
            case ONE_POINT_CROSSING -> crossing = new OnePointCrossing(chance);
            case THREE_POINTS_CROSSING -> crossing = new ThreePointsCrossing(chance);
            case TWO_POINTS_CROSSING -> crossing = new TwoPointsCrossing(chance);
        }
    }

    private void setGradeStrategy(StrategyEnums.GradeOptions strategy) {
        switch (strategy) {
            case MAXIMAL_GRADE -> grade = new MaximalGrade(functionToOptimize);
            case MINIMAL_GRADE -> grade = new MinimalGrade(functionToOptimize);
        }
    }

    private void setMutationStrategy(StrategyEnums.MutationOptions strategy, double chance) {
        switch (strategy) {
            case EDGE_MUTATION -> mutation = new EdgeMutation(chance);
            case ONE_POINT_MUTATION -> mutation = new OnePointMutation(chance);
            case TWO_POINTS_MUTATION -> mutation = new TwoPointsMutation(chance);
        }
    }

    private void setSelectionStrategy(StrategyEnums.SelectionOptions strategy, double parameter) {
        switch (strategy) {
            case BEST_SELECTION -> selection = new BestSelection(parameter);
            case ROULETTE_SELECTION -> selection = new RouletteSelection();
            case TOURNAMENT_SELECTION -> selection = new TournamentSelection(parameter);
        }
    }

}
