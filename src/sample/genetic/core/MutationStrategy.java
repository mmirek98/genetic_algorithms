package sample.genetic.core;

import java.util.ArrayList;

public interface MutationStrategy {
    Population make(Population population);
}
