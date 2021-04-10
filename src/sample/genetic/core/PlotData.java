package sample.genetic.core;

import java.util.ArrayList;
import java.util.List;

public class PlotData {
    private static List<Double> maxGrades = new ArrayList<>();
    private static List<Double> means = new ArrayList<>();
    private static List<Double> standardDeviations = new ArrayList<>();

    public static List<Double> getMaxGrades() {
        return maxGrades;
    }

    public static List<Double> getMeans() {
        return means;
    }

    public static List<Double> getStandardDeviations() {
        return standardDeviations;
    }

    public static void setParams(Population population) {
        int bestIt = 0;
        double best = population.getElement(0).getGrade();
        double sum = 0;
        double mean = 0;
        for(int i = 0; i < population.getPopulationSize(); i++) {
            if(population.getElement(i).getGrade() > best) {
                bestIt = i;
                best = population.getElement(i).getGrade();
            }
            sum += function(i, population);
        }
        mean = sum / population.getPopulationSize();

        double squaresSum = 0;
        for(int i = 0; i < population.getPopulationSize(); i++) {
            squaresSum += Math.pow(function(i, population) - mean, 2);
        }

        means.add(mean);
        maxGrades.add(function(bestIt, population));
        standardDeviations.add(Math.sqrt(squaresSum / population.getPopulationSize()));
    }

    private static double function(int i, Population population) {
        return Math.pow(population.getFirstChromosomeRealNumber(i), 2) + Math.pow(population.getSecondChromosomeRealNumber(i), 2);
    }
}
