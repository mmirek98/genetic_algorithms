package app.genetic.mutation;

import app.genetic.core.Population;

public interface MutationStrategy {
    Population make(Population population);
}
