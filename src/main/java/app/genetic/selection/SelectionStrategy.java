package app.genetic.selection;

import app.genetic.core.Population;

public interface SelectionStrategy {
    Population make(Population population);
}
