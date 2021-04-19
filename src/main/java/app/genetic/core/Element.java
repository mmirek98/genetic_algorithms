package app.genetic.core;

public class Element implements Comparable<Element> {
    double gene;
    double secondGene;
    double grade;

    public Element(double gene, double secondGene, double grade) {
        this.gene = gene;
        this.secondGene = secondGene;
        this.grade = grade;
    }

    public double getGene(int i) {
        if(i == 0) {
            return gene;
        } else if(i == 1) {
            return secondGene;
        } else {
            System.out.println("err " + i);
            return 0;
        }
    }

    public void setGene(double gene, int i) {
        if(i == 0) {
            this.gene = gene;
        } else if (i == 1) {
            this.secondGene = gene;
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
