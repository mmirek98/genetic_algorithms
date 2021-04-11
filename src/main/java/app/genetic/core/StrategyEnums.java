package app.genetic.core;

public class StrategyEnums {
    public enum MutationOptions {
        EDGE_MUTATION,
        ONE_POINT_MUTATION,
        TWO_POINTS_MUTATION
    }

    public enum CrossingOptions {
        HOMOGENEOUS_CROSSING,
        ONE_POINT_CROSSING,
        THREE_POINTS_CROSSING,
        TWO_POINTS_CROSSING
    }

    public enum SelectionOptions {
        BEST_SELECTION,
        ROULETTE_SELECTION,
        TOURNAMENT_SELECTION
    }

    public enum GradeOptions {
        MAXIMAL_GRADE,
        MINIMAL_GRADE
    }
}
