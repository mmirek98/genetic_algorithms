package app.genetic.mutation;

import app.genetic.core.Population;

public interface MutationStrategy {
    void make(Population population);
}
