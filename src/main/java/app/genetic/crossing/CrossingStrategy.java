package app.genetic.crossing;

import app.genetic.core.Population;

public interface CrossingStrategy {
    Population make(Population population);
}
