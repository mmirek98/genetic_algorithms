package sample.genetic.core;

public class ReadingAttributes {

    private final StrategyEnums.GradeOptions gradeStrategy;
    private final StrategyEnums.MutationOptions mutationStrategy;
    private final StrategyEnums.CrossingOptions crossingStrategy;
    private final StrategyEnums.SelectionOptions selectionStrategy;
    private final int populationSize;
    private final int numberOfEpochs;
    private final double mutationChance;
    private final double crossingChance;
    private final double inversionChance;
    private final int eliteElements;
    private final int chromosomeAccuracy;
    private final double populationLeftBoundary;
    private final double populationRightBoundary;
    private final double selectionParameter;

    private ReadingAttributes(final AttributesBuilder builder) {
        this.gradeStrategy = builder.gradeStrategy;
        this.mutationStrategy = builder.mutationStrategy;
        this.crossingStrategy = builder.crossingStrategy;
        this.selectionStrategy = builder.selectionStrategy;
        this.populationSize = builder.populationSize;
        this.numberOfEpochs = builder.numberOfEpochs;
        this.mutationChance = builder.mutationChance;
        this.crossingChance = builder.crossingChance;
        this.inversionChance = builder.inversionChance;
        this.eliteElements = builder.eliteElements;
        this.chromosomeAccuracy = builder.chromosomeAccuracy;
        this.populationLeftBoundary = builder.populationLeftBoundary;
        this.populationRightBoundary = builder.populationRightBoundary;
        this.selectionParameter = builder.selectionParameter;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getNumberOfEpochs() {
        return numberOfEpochs;
    }

    public double getMutationChance() {
        return mutationChance;
    }

    public double getCrossingChance() {
        return crossingChance;
    }

    public double getInversionChance() {
        return inversionChance;
    }

    public double getPopulationLeftBoundary() {
        return populationLeftBoundary;
    }

    public double getPopulationRightBoundary() {
        return populationRightBoundary;
    }

    public int getEliteElements() {
        return eliteElements;
    }

    public int getChromosomeAccuracy() {
        return chromosomeAccuracy;
    }

    public double getSelectionParameter() { return selectionParameter; }

    public StrategyEnums.GradeOptions getGradeStrategy() {
        return gradeStrategy;
    }

    public StrategyEnums.MutationOptions getMutationStrategy() {
        return mutationStrategy;
    }

    public StrategyEnums.CrossingOptions getCrossingStrategy() {
        return crossingStrategy;
    }

    public StrategyEnums.SelectionOptions getSelectionStrategy() {
        return selectionStrategy;
    }

    public static class AttributesBuilder {
        private StrategyEnums.GradeOptions gradeStrategy;
        private StrategyEnums.MutationOptions mutationStrategy;
        private StrategyEnums.CrossingOptions crossingStrategy;
        private StrategyEnums.SelectionOptions selectionStrategy;
        private int populationSize;
        private int numberOfEpochs;
        private double mutationChance;
        private double crossingChance;
        private double inversionChance;
        private double populationLeftBoundary;
        private double populationRightBoundary;
        private int eliteElements;
        private int chromosomeAccuracy;
        private double selectionParameter;

        public AttributesBuilder gradeStrategy(final StrategyEnums.GradeOptions strategy) {
            gradeStrategy = strategy;
            return this;
        }

        public AttributesBuilder mutationStrategy(final StrategyEnums.MutationOptions strategy) {
            mutationStrategy = strategy;
            return this;
        }

        public AttributesBuilder crossingStrategy(StrategyEnums.CrossingOptions strategy) {
            crossingStrategy = strategy;
            return this;
        }

        public AttributesBuilder selectionStrategy(StrategyEnums.SelectionOptions strategy) {
            selectionStrategy = strategy;
            return this;
        }

        public AttributesBuilder populationSize(int populationSize) {
            this.populationSize = populationSize;
            return this;
        }

        public AttributesBuilder numberOfEpochs(int numberOfEpochs) {
            this.numberOfEpochs = numberOfEpochs;
            return this;
        }

        public AttributesBuilder mutationChance(double mutationChance) {
            this.mutationChance = mutationChance;
            return this;
        }

        public AttributesBuilder crossingChance(double crossingChance) {
            this.crossingChance = crossingChance;
            return this;
        }

        public AttributesBuilder inversionChance(double inversionChance) {
            this.inversionChance = inversionChance;
            return this;
        }

        public AttributesBuilder populationLeftBoundary(double populationLeftBoundary) {
            this.populationLeftBoundary = populationLeftBoundary;
            return this;
        }

        public AttributesBuilder populationRightBoundary(double populationRightBoundary) {
            this.populationRightBoundary = populationRightBoundary;
            return this;
        }

        public AttributesBuilder eliteElements(int eliteElements) {
            this.eliteElements = eliteElements;
            return this;
        }

        public AttributesBuilder chromosomeAccuracy(int chromosomeAccuracy) {
            this.chromosomeAccuracy = chromosomeAccuracy;
            return this;
        }

        public AttributesBuilder selectionParameter(double selectionParameter) {
            this.selectionParameter = selectionParameter;
            return this;
        }

        public ReadingAttributes build() {
            return new ReadingAttributes(this);
        }
    }

}
