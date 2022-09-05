import java.util.Scanner;

public class MainBonus
{
    public static void main(String[] args)
    {
        Scanner ClockInput = new Scanner(System.in);
        
        System.out.print("Enter Hour: ");
        int hour = ClockInput.nextInt();
        System.out.print("Enter Minute: ");
        int minute = ClockInput.nextInt();
        System.out.print("Enter Second: ");
        int second = ClockInput.nextInt();
        
        ClockBonus time = new ClockBonus(hour, minute, second);
        System.out.println("Time is: " + time);
    }
}
