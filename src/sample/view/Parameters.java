package sample.view;
import sample.genetic.core.StrategyEnums;

public class Parameters {
    private int populationSize;
    private int epochsNumber;
    private int chromosomeAccuracy;
    private StrategyEnums.SelectionOptions selectionStrategy;
    private StrategyEnums.CrossingOptions crossingStrategy;
    private StrategyEnums.MutationOptions mutationStrategy;
    private StrategyEnums.GradeOptions gradeStrategy;
    private double crossingChance;
    private double mutationChance;
    private double inversionChance;
    private int eliteStrategyAmount;

    public int getPopulationSize() {
        return populationSize;
    }

    public int getEpochsNumber() {
        return epochsNumber;
    }

    public int getChromosomeAccuracy() {
        return chromosomeAccuracy;
    }

    public StrategyEnums.SelectionOptions getSelectionStrategy() {
        return selectionStrategy;
    }

    public StrategyEnums.CrossingOptions getCrossingStrategy() {
        return crossingStrategy;
    }

    public StrategyEnums.MutationOptions getMutationStrategy() {
        return mutationStrategy;
    }

    public StrategyEnums.GradeOptions getGradeStrategy() {
        return gradeStrategy;
    }

    public double getCrossingChance() {
        return crossingChance;
    }

    public double getMutationChance() {
        return mutationChance;
    }

    public double getInversionChance() {
        return inversionChance;
    }

    public int getEliteStrategyAmount() {
        return eliteStrategyAmount;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public void setEpochsNumber(int epochsNumber) {
        this.epochsNumber = epochsNumber;
    }

    public void setChromosomeAccuracy(int chromosomeAccuracy) {
        this.chromosomeAccuracy = chromosomeAccuracy;
    }

    public void setSelectionStrategy(StrategyEnums.SelectionOptions selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

    public void setCrossingStrategy(StrategyEnums.CrossingOptions crossingStrategy) {
        this.crossingStrategy = crossingStrategy;
    }

    public void setMutationStrategy(StrategyEnums.MutationOptions mutationStrategy) {
        this.mutationStrategy = mutationStrategy;
    }

    public void setGradeStrategy(StrategyEnums.GradeOptions gradeStrategy) {
        this.gradeStrategy = gradeStrategy;
    }

    public void setCrossingChance(double crossingChance) {
        this.crossingChance = crossingChance;
    }

    public void setMutationChance(double mutationChance) {
        this.mutationChance = mutationChance;
    }

    public void setInversionChance(double inversionChance) {
        this.inversionChance = inversionChance;
    }

    public void setEliteStrategyAmount(int eliteStrategyAmount) {
        this.eliteStrategyAmount = eliteStrategyAmount;
    }
}
