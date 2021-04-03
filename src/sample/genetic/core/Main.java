package sample.genetic.core;

public class Main {
    public static void main(String [] args) {
        ReadingAttributes read= new ReadingAttributes.AttributesBuilder()
                .populationSize(10)
                .numberOfEpochs(40)
                .chromosomeAccuracy(6)
                .selectionStrategy(1)
                .crossingStrategy(1)
                .mutationStrategy(2)
                .gradeStrategy(0)
                .crossingChance(1)
                .mutationChance(1)
                .inversionChance(1)
                .eliteElements(4)
                .build();
        SetParams param = new SetParams();
        param.setParams(read);
    }
}
