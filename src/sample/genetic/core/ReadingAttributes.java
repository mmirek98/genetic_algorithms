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

    public int getEliteElements() {
        return eliteElements;
    }

    public int getChromosomeAccuracy() {
        return chromosomeAccuracy;
    }

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
        private int eliteElements;
        private int chromosomeAccuracy;

        public AttributesBuilder gradeStrategy(final int strategy) {
            switch (strategy) {
                case 0 -> gradeStrategy = StrategyEnums.GradeOptions.MAXIMAL_GRADE;
                case 1 -> gradeStrategy = StrategyEnums.GradeOptions.MINIMAL_GRADE;
            }
            return this;
        }

        public AttributesBuilder mutationStrategy(final int strategy) {
            switch (strategy) {
                case 0 -> mutationStrategy = StrategyEnums.MutationOptions.EDGE_MUTATION;
                case 1 -> mutationStrategy = StrategyEnums.MutationOptions.ONE_POINT_MUTATION;
                case 2 -> mutationStrategy = StrategyEnums.MutationOptions.TWO_POINTS_MUTATION;
            }
            return this;
        }

        public AttributesBuilder crossingStrategy(int strategy) {
            switch (strategy) {
                case 0 -> crossingStrategy = StrategyEnums.CrossingOptions.HOMOGENEOUS_CROSSING;
                case 1 -> crossingStrategy = StrategyEnums.CrossingOptions.ONE_POINT_CROSSING;
                case 2 -> crossingStrategy = StrategyEnums.CrossingOptions.THREE_POINTS_CROSSING;
                case 3 -> crossingStrategy = StrategyEnums.CrossingOptions.TWO_POINTS_CROSSING;
            }
            return this;
        }

        public AttributesBuilder selectionStrategy(int strategy) {
            switch (strategy) {
                case 0 -> selectionStrategy = StrategyEnums.SelectionOptions.BEST_SELECTION;
                case 1 -> selectionStrategy = StrategyEnums.SelectionOptions.ROULETTE_SELECTION;
                case 2 -> selectionStrategy = StrategyEnums.SelectionOptions.TOURNAMENT_SELECTION;
            }
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

        public AttributesBuilder eliteElements(int eliteElements) {
            this.eliteElements = eliteElements;
            return this;
        }

        public AttributesBuilder chromosomeAccuracy(int chromosomeAccuracy) {
            this.chromosomeAccuracy = chromosomeAccuracy;
            return this;
        }

        public ReadingAttributes build() {
            return new ReadingAttributes(this);
        }
    }

}
