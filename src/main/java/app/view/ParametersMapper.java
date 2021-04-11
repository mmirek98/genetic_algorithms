package app.view;

import app.genetic.core.StrategyEnums;
import java.util.Map;


//  'rangeBegin',
//   'rangeEnd',
//   'populationCount',
//   'bitsCount',
//   'epochsCount',
//   'chromosomeAmount',
//   'eliteStrategyAmount',
//   'crossProbability',
//   'mutationProbability',
//   'inversionProbability',
//   'selectionMethod',
//   'crossMethod',
//   'mutationMethod',
//   'optimizationType'

public class ParametersMapper {
    private static final String populationSizeId = "populationCount";
    private static final String epochsCountId = "epochsCount";
    private static final String selectionParameterId = "selectionParameter";
    private static final String selectionStrategyId = "selectionMethod";
    private static final String crossingStrategyId = "crossMethod";
    private static final String mutationStrategyId = "mutationMethod";
    private static final String mutationChanceId = "mutationProbability";
    private static final String eliteStrategyElementsId = "eliteStrategyAmount";
    private static final String inversionChanceId = "inversionProbability";
    private static final String crossingChanceId = "crossProbability";
    //    TODO: add following params to front & other required
    private static final String rangeBeginId = "rangeBegin";
    private static final String rangeEndId = "rangeEnd";
    private static final String chromosomeAccuracyId = "chromosomeAccuracy";
    private static final String gradeStrategyId = "optimizationType";


    public static Parameters toParameters(Map<String, String> params) {
        Parameters parsedParameters = new Parameters();

        // TODO: this may be builder
        setPopulationSize(Integer.parseInt(params.get(populationSizeId)), parsedParameters);
        setEpochsCount(Integer.parseInt(params.get(epochsCountId)), parsedParameters);
        setSelectionStrategy(params.get(selectionStrategyId), parsedParameters);
        setCrossingStrategy(params.get(crossingStrategyId), parsedParameters);
        setMutationStrategy(params.get(mutationStrategyId), parsedParameters);
        setMutationChance(Double.parseDouble(params.get(mutationChanceId)), parsedParameters);
        setEliteStrategyElements(Integer.parseInt(params.get(eliteStrategyElementsId)), parsedParameters);
        setInversionChance(Double.parseDouble(params.get(inversionChanceId)), parsedParameters);
        setCrossingChance(Double.parseDouble(params.get(crossingChanceId)), parsedParameters);
        setChromosomeAccuracy(Integer.parseInt(params.get(chromosomeAccuracyId)), parsedParameters);
        setGradeStrategy(params.get(gradeStrategyId), parsedParameters);
        setRangeBegin(Double.parseDouble(params.get(rangeBeginId)), parsedParameters);
        setRangeEnd(Double.parseDouble(params.get(rangeEndId)), parsedParameters);
        setSelectionParameter(Double.parseDouble(params.get(selectionParameterId)), parsedParameters);

        return parsedParameters;
    }

    private static void setPopulationSize(int value, Parameters parsedParameters) {
        parsedParameters.setPopulationSize(value);
    }


    private static void setSelectionParameter(double value, Parameters parsedParameters) {
        parsedParameters.setSelectionParameter(value);
    }

    private static void setEpochsCount(int value, Parameters parsedParameters) {
        parsedParameters.setEpochsNumber(value);
    }

    private static void setSelectionStrategy(String strategy, Parameters parsedParameters) {
        StrategyEnums.SelectionOptions chosenStrategy = switch (strategy) {
            case "best" -> StrategyEnums.SelectionOptions.BEST_SELECTION;
            case "roulette" -> StrategyEnums.SelectionOptions.ROULETTE_SELECTION;
            case "tournament" -> StrategyEnums.SelectionOptions.TOURNAMENT_SELECTION;
            default -> StrategyEnums.SelectionOptions.BEST_SELECTION;
        };

        parsedParameters.setSelectionStrategy(chosenStrategy);
    }

    private static void setCrossingStrategy(String strategy, Parameters parsedParameters) {
        StrategyEnums.CrossingOptions chosenStrategy = switch (strategy) {
            case "twoPoints" -> StrategyEnums.CrossingOptions.TWO_POINTS_CROSSING;
            case "threePoints" -> StrategyEnums.CrossingOptions.THREE_POINTS_CROSSING;
            case "homo" -> StrategyEnums.CrossingOptions.HOMOGENEOUS_CROSSING;
            default -> StrategyEnums.CrossingOptions.ONE_POINT_CROSSING;
        };

        parsedParameters.setCrossingStrategy(chosenStrategy);
    }

    private static void setMutationStrategy(String strategy, Parameters parsedParameters) {
        StrategyEnums.MutationOptions chosenStrategy = switch (strategy) {
            case "twoPoints" -> StrategyEnums.MutationOptions.TWO_POINTS_MUTATION;
            case "edge" -> StrategyEnums.MutationOptions.EDGE_MUTATION;
            default -> StrategyEnums.MutationOptions.ONE_POINT_MUTATION;
        };

        parsedParameters.setMutationStrategy(chosenStrategy);
    }

    private static void setMutationChance(double value, Parameters parsedParameters) {
        parsedParameters.setMutationChance(value);
    }

    private static void setEliteStrategyElements(int value, Parameters parsedParameters) {
        parsedParameters.setEliteStrategyAmount(value);
    }

    private static void setInversionChance(double value, Parameters parsedParameters) {
        parsedParameters.setInversionChance(value);
    }

    private static void setCrossingChance(double value, Parameters parsedParameters) {
        parsedParameters.setCrossingChance(value);
    }

    private static void setChromosomeAccuracy(int value, Parameters parsedParameters) {
        parsedParameters.setChromosomeAccuracy(value);
    }

    private static void setGradeStrategy(String strategy, Parameters parsedParameters) {
        StrategyEnums.GradeOptions chosenStrategy = switch (strategy) {
            case "minimization" -> StrategyEnums.GradeOptions.MINIMAL_GRADE;
            default -> StrategyEnums.GradeOptions.MAXIMAL_GRADE;
        };

        parsedParameters.setGradeStrategy(chosenStrategy);
    }

    private static void setRangeBegin(double value, Parameters parsedParameters) {
        parsedParameters.setLeftRange(value);
    }

    private static void setRangeEnd(double value, Parameters parsedParameters) {
        parsedParameters.setRightRange(value);
    }
}
