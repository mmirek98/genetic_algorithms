package app.genetic.function;

public class BealeFunction implements Function {
    @Override
    public double calculate(double x, double y) {
        return Math.pow(1.5 - x + x*y, 2)
                + Math.pow(2.25 - x + x*Math.pow(y, 2), 2)
                + Math.pow(2.625 - x + x*Math.pow(y, 3), 2);
    }
}
