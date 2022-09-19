public class ElectricVehicle extends Vehicle
{
    public static double centsPerKwhOfElectricity = Double.NaN;
    private double whPerMile;
    public double kwhInBattery;
    
    public ElectricVehicle(int year, String make, String model, BodyStyle bodystyle, double whPerMile, double kwhInBattery)
    {
        super(year, make, model, bodystyle);
        this.whPerMile = whPerMile;
        this.kwhInBattery = kwhInBattery;
    }
    
    @Override
    public double range()
    {
        return kwhInBattery * 1000 / whPerMile;
    }
    
    @Override
    public double fuelConsumed(double miles)
    {
        double result = miles * (whPerMile / 1000);
        if (result > kwhInBattery)
        {
            throw new ArithmeticException("Fuel cannot be less than 0");
        }
        return result;
    }
    
    @Override
    public double dollarsToTravel(double miles)
    {
        return fuelConsumed(miles) * (centsPerKwhOfElectricity/100);
    }
}
