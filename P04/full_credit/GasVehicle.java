public class GasVehicle extends Vehicle
{
    public static double dollarsPerGallonOfGas = Double.NaN;
    private double milesPerGallon;
    private double gallonsInTank;

    public GasVehicle(int year, String make, String model, BodyStyle bodystyle, double milesPerGallon, double gallonsInTank)
    {
        super(year, make, model, bodystyle);
        this.milesPerGallon = milesPerGallon;
        this.gallonsInTank = gallonsInTank;
    }
    
    @Override
    public double range()
    {
        return gallonsInTank * milesPerGallon;
    }
    
    @Override
    public double fuelConsumed(double miles)
    {
        double result = miles / milesPerGallon;
        if (result > gallonsInTank)
        {
            throw new ArithmeticException("Fuel cannot be less than 0");
        }
        return result;
    }

    @Override
    public double dollarsToTravel(double miles)
    {
        return fuelConsumed(miles) * dollarsPerGallonOfGas;
    }
}
