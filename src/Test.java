/**
 * Created by Kevin Mattmueller on 29.12.2014.
 */
public class Test {
    public static void main(String[] args) {

        MetropolisProb mp = new MetropolisProb();

        double paramT = 0.1;
        double startingPointX=20;
        double stepSize = 1;
        int steps = 2000;
        int selectedFormula = 1;

        double calculatedMinValue = mp.calculate(startingPointX, stepSize, paramT, steps, selectedFormula);

        System.out.println("Minima: "+ calculatedMinValue);
    }
}
