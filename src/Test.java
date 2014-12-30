/**
 * Created by Kevin on 29.12.2014.
 */
public class Test {
    public static void main(String[] args) {

        MetropolisProb mp = new MetropolisProb();

        double paramT = 0.1;
        double startingPointX=4;
        double stepSize = 1;
        int iterations = 100000;
        int selectedFormula = 2;

        double caclulatedMinValue = mp.calculate(startingPointX, stepSize, paramT, iterations, selectedFormula);

        System.out.println("Minima: "+ caclulatedMinValue);
    }
}
