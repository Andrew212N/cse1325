import java.util.Scanner;

public class Main
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
        
        Clock time = new Clock(hour, minute, second);
        System.out.println("Time is: " + time);
    }
}
