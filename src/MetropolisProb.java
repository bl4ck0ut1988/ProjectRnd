/**
 * Created by Kevin Mattmueller on 29.12.2014.
 */
public class MetropolisProb {

    public MetropolisProb (){
    }

    /**
     * The calculate method performs the metropolis algorithm with given parameters.
     * @param startingPositionX X-position from where the Algorithm starts.
     * @param stepSize size of random step
     * @param parameterT used in metropolis algorithm calculations. Will increase/decrease the chance of accepting a new x-position if newY is bigger than currentY.
     * @param steps number of random steps to take.
     * @return the Y-Coordinate of the lowest found minima.
     */
    public double calculate(double startingPositionX, double stepSize, double parameterT, int steps, int formula){

        double minValue = functions(startingPositionX, formula);
        double currentPositionX=startingPositionX;
        double newPositionX;

        for (int i=0; i<steps; i++){
            System.out.println("--------------\n"+"Step Nr."+(i+1));
            System.out.println("Current X-Position: "+currentPositionX);
            newPositionX = randomStep(currentPositionX, stepSize);
            System.out.println("Considered new X-Position: "+newPositionX);
            double currentY = functions(currentPositionX, formula);
            double newY = functions(newPositionX, formula);
            if (newY < currentY){
                currentPositionX = newPositionX;
                System.out.println("New X-Position: "+currentPositionX);
                if(newY < minValue){
                    minValue = newY;
                }
            }
            else{
                double metropolisProb = Math.pow(Math.E, -((newY - currentY)/(parameterT)));
                if(Math.random()<=metropolisProb){
                    currentPositionX = newPositionX;
                    System.out.println("New X-Position(Metropolis): "+currentPositionX);
                }
            }
        }

        return minValue;
    }

    /**
     * The randomStep method takes the current x-position and sets a new position in a random direction.
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
     * This method contains a collection of functions.
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
