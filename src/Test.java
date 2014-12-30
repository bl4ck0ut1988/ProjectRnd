/**
 * Created by Kevin on 29.12.2014.
 */
public class Test {
    public static void main(String[] args) {

        MetropolisProb mp = new MetropolisProb();

        double paramT = 0.1;
        double startingPointX=100;
        double stepSize = 0.5;
        int iterations = 1000;
        int selectedFormula = 0;

        double caclulatedMinValue = mp.calculate(startingPointX, stepSize, paramT, iterations, selectedFormula);

        System.out.println("Min-Value: "+ caclulatedMinValue);
    }
}
