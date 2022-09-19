import java.util.Scanner;
import java.util.ArrayList;

public class TravelCost
{
    public static void main(String args[])
    {
        Scanner vehicleInput = new Scanner(System.in);
        
        System.out.print("Enter price per gallon of gas(dollars): ");
        GasVehicle.dollarsPerGallonOfGas = vehicleInput.nextDouble();
        System.out.print("Enter price per KWh of electricity(cents): ");
        ElectricVehicle.centsPerKwhOfElectricity = vehicleInput.nextDouble();
        System.out.print("How many miles is the trip? ");
        double miles = vehicleInput.nextDouble();
        
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        vehicles.add(new ElectricVehicle(2022, "Telsa",    "Model S Plaid",   BodyStyle.Sedan,     297, 100  ));
        vehicles.add(new ElectricVehicle(2022, "Telsa",    "Model 3 LR",      BodyStyle.Sedan,     242,  82  ));
        vehicles.add(new ElectricVehicle(2022, "GM",       "Bolt",            BodyStyle.Hatchback, 286,  66  ));
        vehicles.add(new ElectricVehicle(2022, "Nissan",   "LEAF",            BodyStyle.Hatchback, 269,  60  ));
        vehicles.add(new ElectricVehicle(2022, "Ford",     "Mustang Mach-E",  BodyStyle.SUV,       347,  88  ));
        vehicles.add(new ElectricVehicle(2022, "Ford",     "F-150 Lightning", BodyStyle.Truck,     511, 131  ));
        vehicles.add(new GasVehicle(     2022, "Ford",     "F-150",           BodyStyle.Truck,      25,  23  ));
        vehicles.add(new GasVehicle(     2022, "Toyota",   "Prius Hybrid",    BodyStyle.Hatchback,  55,  11.4));
        vehicles.add(new GasVehicle(     2022, "Toyota",   "RAV4",            BodyStyle.Crossover,  31,  14.5));
        vehicles.add(new GasVehicle(     2022, "Nissan",   "Rogue",           BodyStyle.Hatchback,  33,  14.5));
        vehicles.add(new GasVehicle(     2022, "Chrysler", "Pacifica",        BodyStyle.Minivan,    24,  19  ));
        vehicles.add(new GasVehicle(     2022, "Chrysler", "Pacifica Hybrid", BodyStyle.Minivan,    30,  16.5));
        
        for(int counter = 0; counter < vehicles.size(); counter++)
        {
            System.out.printf("$ %.2f ", vehicles.get(counter).dollarsToTravel(miles));
            System.out.printf("(Range: %.0f)", vehicles.get(counter).range());
            System.out.println(vehicles.get(counter));
        }
    }
}
