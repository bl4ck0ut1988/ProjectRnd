/**
 * Created by Kevin on 29.12.2014.
 */
public class Test {
    public static void main(String[] args) {

        MetropolisProb mp = new MetropolisProb();

        double paramT = 0.1;
        double startValue=30;
        double stepSize = 0.5;
        int iterations = 10000;

        System.out.println("Min-Value: "+ mp.calculate(startValue, stepSize, paramT, iterations));
    }
}
