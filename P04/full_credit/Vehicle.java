abstract class Vehicle
{
    private int year;
    private String make;
    private String model;
    private BodyStyle bodystyle;

    public Vehicle(int year, String make, String model, BodyStyle bodystyle)
    {
        this.year = year;
        this.make = make;
        this.model = model;
        this.bodystyle = bodystyle;
    }
    
    public abstract double range(double amountOfFuel, double milesPerFuel);
    public abstract double fuelConsumed(double miles);
    public abstract double dollarsToTravel(double miles);
    
    @Override
    public String toString()
    {
        return " " + this.year + " " + this.make + " " + this.model + " " + this.bodystyle + " ";
    }
}
