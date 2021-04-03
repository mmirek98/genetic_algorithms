package sample.genetic.core;

import java.util.ArrayList;

public class Inversion {
    private final double chance;

    Inversion(double chance) {
        this.chance = chance;
    }

    public void make(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i++) {
            double inversionChance = Math.random();
            if(inversionChance <= chance) {
                int startInversion;
                int endInversion;
                int firstNum = (int) (Math.random() * (population.getChromosomeSize()));
                int secondNum = (int) (Math.random() * (population.getChromosomeSize()));
                if(firstNum > secondNum) {
                    endInversion = firstNum;
                    startInversion = secondNum;
                } else {
                    startInversion = firstNum;
                    endInversion = secondNum;
                }
                String firstSubstr = population.getElement(i).getChromosome().substring(0, startInversion);
                String inversionPart = population.getElement(i).getChromosome().substring(startInversion, endInversion + 1);
                String secondSubstr = population.getElement(i).getChromosome().substring(endInversion + 1);
                StringBuilder input1 = new StringBuilder();
                input1.append(inversionPart);
                input1.reverse();
                population.getElement(i).setChromosome(firstSubstr + input1 + secondSubstr);
            }
        }

    }
}
