public class ElectricVehicle extends Vehicle
{
    public double centerPerKwhOfElectricity;
    private double whPerMile;
    public double kwhInBattery;

    public ElectricVehicle(int year, String make, BodyStyle bodystyle, double whPerMile, double kwhInBattery)
    {
        this.year = year;
        this.make = make;
        this.bodystyle = bodystyle;
        this.whPerMile = whPerMile;
        this.kwhInBattery = kwhInBattery;
    }
    
    @Override
    public double range()
    
    @Override
    public double fuelConsumed(double miles)
    
    @Override
    public double dollarsToTravel(double miles)
}
