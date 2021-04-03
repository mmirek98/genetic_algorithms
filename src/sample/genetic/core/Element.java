package sample.genetic.core;

public class Element implements Comparable<Element> {
    String chromosome;
    double grade;

    public Element(String chromosome, double grade) {
        this.chromosome = chromosome;
        this.grade = grade;
    }

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Element o) {
        return Double.compare(this.grade,o.grade);
    }
}
