package app.genetic.core;

public class StrategyEnums {
    public enum MutationOptions {
        UNIFORM_MUTATION
    }

    public enum CrossingOptions {
        ARITHMETIC_CROSSING,
        HEURISTIC_CROSSING,
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
