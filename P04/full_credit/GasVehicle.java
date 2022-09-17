public class GasVehicle extends Vehicle
{
    public double dolalrsPerGallonOfGas;
    private double milesPerGallon;
    private double gallonsInTank;

    public ElectricVehicle(int year, String make, BodyStyle bodystyle, double milesPerGallon, double gallonsInTank)
    {
        this.year = year;
        this.make = make;
        this.bodystyle = bodystyle;
        this.milesPerGallon = milesPerGallon;
        this.gallonsInTank = gallonsInTank;
    }
    
    @Override
    public double range()
    
    @Override
    public double fuelConsumed(double miles)
    
    @Override
    public double dollarsToTravel(double miles)
}
