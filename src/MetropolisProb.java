/**
 * Created by Kevin on 29.12.2014.
 */
public class MetropolisProb {

    public MetropolisProb (){
    }

    /**
     *
     * @param startingPositionX x-coordinate from where the Algorithm starts
     * @param stepSize size of iteration steps
     * @param parameterT used in metropolis algorithm calculations
     * @param iterations number of algorithm iterations
     * @return the X-Coordinate of the minima
     */
    public double calculate(double startingPositionX, double stepSize, double parameterT, int iterations, int formula){

        double minValue = functions(startingPositionX, formula);
        double currentPositionX=startingPositionX;
        double newPositionX;

        for (int i=0; i<iterations; i++){
            newPositionX = randomStep(currentPositionX, stepSize);
            System.out.println("newPosX: "+newPositionX);
            double currentY = functions(currentPositionX, formula);
            double newY = functions(newPositionX, formula);
            if (newY < currentY){
                currentPositionX = newPositionX;
                if(newY < minValue){
                    minValue = newY;
                }
            }
            else{
                double metropolisProb = Math.pow(Math.E, -((newY - currentY)/(parameterT)));
                if(Math.random()<=metropolisProb){
                    currentPositionX = newPositionX;
                }
            }
        }

        return minValue;
    }

    /**
     *
     * @param value value which gets iterated
     * @param stepSize size of iteration steps
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

    /**
     *
     * @param x current x-value
     * @param selection used to select the desired formula
     * @return calculated y-value
     */
    public double functions(double x, int selection){

        double y=0;

        switch (selection){
            case 0: y = Math.pow(x, 2);
                    break;

            case 1: y = Math.pow(x, 2)+3;
                    break;

            case 2: y = ((3*x)/(Math.pow(x,2)+1));
                    break;
        }

        return y;
    }
}
