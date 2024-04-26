
/**
 * Write a description of class Horse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Horse
{
    //Fields of class Horse

    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean fallen;
    private double confidence;

    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
        this.name = horseName;
        this.symbol = horseSymbol;
        this.confidence = Math.max(horseConfidence, 0.1);
    }



    //Other methods of class Horse
    public void fall()
    {
        this.confidence-=0.1;
        this.fallen = true;
    }

    public double getConfidence()
    {
        return this.confidence;
    }

    public int getDistanceTravelled()
    {
        return this.distanceTravelled;
    }

    public String getName()
    {
        return this.name;
    }

    public char getSymbol()
    {
        return this.symbol;
    }

    public void goBackToStart()
    {
        this.distanceTravelled = 0;
    }

    public boolean hasFallen()
    {
        return this.fallen;
    }

    public void moveForward()
    {
        this.distanceTravelled+=1;
    }

    public void setConfidence(double newConfidence)
    {
        this.confidence = newConfidence;
    }

    public void setSymbol(char newSymbol)
    {
        this.symbol = newSymbol;
    }

}
