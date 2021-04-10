package sample.view;

import sample.genetic.core.ReadingAttributes;
import sample.genetic.core.SetParams;

import java.util.concurrent.Callable;


public class LearningRunner implements Callable<Double> {
    private Parameters params;
    private double winnerValue;
    private volatile boolean shouldBeCanceled = false;


    LearningRunner(Parameters params) {
        this.params = params;
    }

    public double getWinnerValue() {
        return winnerValue;
    }

    public void cancel() {
        this.shouldBeCanceled = true;
    }

    @Override
    public Double call() throws Exception {
        ReadingAttributes read = new ReadingAttributes.AttributesBuilder()
                .populationSize(params.getPopulationSize())
                .populationLeftBoundary(params.getLeftRange())
                .populationRightBoundary(params.getRightRange())
                .numberOfEpochs(params.getEpochsNumber())
                .chromosomeAccuracy(params.getChromosomeAccuracy())
                .selectionStrategy(params.getSelectionStrategy())
                .crossingStrategy(params.getCrossingStrategy())
                .mutationStrategy(params.getMutationStrategy())
                .gradeStrategy(params.getGradeStrategy())
                .crossingChance(params.getCrossingChance())
                .mutationChance(params.getMutationChance())
                .inversionChance(params.getInversionChance())
                .eliteElements(params.getEliteStrategyAmount())
                .selectionParameter(params.getSelectionParameter())
                .build();
        SetParams param = new SetParams();
        this.winnerValue = param.setParams(read);
        return this.winnerValue;
    }
}
