/**
 * Created by Kevin Mattmueller on 29.12.2014.
 */
public class MetropolisProb {

    public MetropolisProb (){
    }

    /**
     *
     * @param startingPositionX X-position from where the Algorithm starts
     * @param stepSize size of random step
     * @param parameterT used in metropolis algorithm calculations. Will increase/decrease the chance of accepting a new x-position if newY > currentY.
     * @param steps number of random steps to take
     * @return the Y-Coordinate of the lowest found minima
     */
    public double calculate(double startingPositionX, double stepSize, double parameterT, int steps, int formula){

        double minValue = functions(startingPositionX, formula);
        double currentPositionX=startingPositionX;
        double newPositionX;

        for (int i=0; i<steps; i++){
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
                System.out.println("Metropolis-Prob: "+metropolisProb);
                if(Math.random()<=metropolisProb){
                    currentPositionX = newPositionX;
                }
            }
        }

        return minValue;
    }

    /**
     *
     * @param xPosition current x-position
     * @param stepSize size of iteration steps
     * @return new x-position in random direction
     */
    public double randomStep(double xPosition, double stepSize){
        if (Math.random() < 0.5){
            xPosition -= stepSize;
        }
        else{
            xPosition += stepSize;
        }
        return xPosition;
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
