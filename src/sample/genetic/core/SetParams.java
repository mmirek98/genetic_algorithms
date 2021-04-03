package sample.genetic.core;

public class SetParams {
    private SelectionStrategy selection;
    private MutationStrategy mutation;
    private CrossingStrategy crossing;
    private GradeStrategy grade;
    private Inversion inversion;
    private Elite elite;

    public double setParams(ReadingAttributes attributes) {
        Algorithm algorithm = new Algorithm();
        Population population = new Population(attributes.getPopulationSize(), attributes.getChromosomeAccuracy());
        algorithm.setNumberOfEpochs(attributes.getNumberOfEpochs());
        setCrossingStrategy(attributes.getCrossingStrategy(), attributes.getCrossingChance());
        setGradeStrategy(attributes.getGradeStrategy());
        setMutationStrategy(attributes.getMutationStrategy(), attributes.getMutationChance());
        setSelectionStrategy(attributes.getSelectionStrategy());
        inversion = new Inversion(attributes.getInversionChance());
        elite = new Elite(attributes.getEliteElements());
        algorithm.makeAlgorithm(population, crossing, grade, mutation, selection, inversion, elite);
        System.out.println("zwyciesca to: " + algorithm.getWinner());
        // TODO: remove return statement & overhaul this class/method
        return algorithm.getWinner();
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
            case MAXIMAL_GRADE -> grade = new MaximalGrade();
            case MINIMAL_GRADE -> grade = new MinimalGrade();
        }
    }

    private void setMutationStrategy(StrategyEnums.MutationOptions strategy, double chance) {
        switch (strategy) {
            case EDGE_MUTATION -> mutation = new EdgeMutation(chance);
            case ONE_POINT_MUTATION -> mutation = new OnePointMutation(chance);
            case TWO_POINTS_MUTATION -> mutation = new TwoPointsMutation(chance);
        }
    }

    private void setSelectionStrategy(StrategyEnums.SelectionOptions strategy) {
        switch (strategy) {
            case BEST_SELECTION -> selection = new BestSelection();
            case ROULETTE_SELECTION -> selection = new RouletteSelection();
            case TOURNAMENT_SELECTION -> selection = new TournamentSelection();
        }
    }

}
