package sample.genetic.core;

public class Element implements Comparable<Element> {
    String chromosome;
    String secondChromosome;
    double grade;

    public Element(String chromosome, String secondChromosome, double grade) {
        this.chromosome = chromosome;
        this.secondChromosome = secondChromosome;
        this.grade = grade;
    }

    public String getChromosome(int i) {
        if(i == 0) {
            return chromosome;
        } else if(i == 1) {
            return secondChromosome;
        } else {
            return "err";
        }
    }

    public void setChromosome(String chromosome, int i) {
        if(i == 0) {
            this.chromosome = chromosome;
        } else if (i == 1) {
            this.secondChromosome = secondChromosome;
        } else {
            System.out.println("err");
        }
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
