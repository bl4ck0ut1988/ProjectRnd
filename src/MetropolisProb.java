/**
 * Created by Kevin on 29.12.2014.
 */
public class MetropolisProb {

    Functions f;

    public MetropolisProb (){
        f = new Functions();
    }

    /**
     *
     * @param startValue
     * @param stepSize
     * @param paramT
     * @param iterations
     * @return
     */
    public double calculate(double startValue, double stepSize, double paramT, int iterations, int formulaSelection){
        double minValue = functions(startValue, formulaSelection);
        for (int i=0; i<iterations; i++){
            System.out.println("Old X: "+startValue);
            startValue = randomStep(startValue, stepSize);
            double tempValue = functions(startValue, formulaSelection);
            if (tempValue < minValue){
                minValue = tempValue;
            }
            else{
                double metropolisProb = Math.pow(Math.E, -((tempValue - minValue)/(paramT)));
                if(Math.random()<=metropolisProb){
                    System.out.println("BOOOOM");
                    minValue = tempValue;
                }
            }
            System.out.println("New X: "+startValue);
            System.out.println("Current Y-Value: "+tempValue);
            System.out.println("Min Y-Value: "+minValue+"\n");
        }
        return minValue;
    }

    /**
     *
     * @param value value which gets iterated
     * @param stepSize size of iteration step
     * @return iterated value
     */
    public double randomStep(double value, double stepSize){
        if (Math.random() <= 0.5){
            value -= stepSize;
        }
        else{
            value += stepSize;
        }
        return value;
    }

    public double functions(double x, int selection){

        double y=0;

        switch (selection){

            case 0: y = Math.pow(x, 2);
                    break;

            case 1: y = Math.pow(x, 2)+3;
                break;
        }

        return y;
    }
}
