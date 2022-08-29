import java.util.Scanner;

public class HelloInput
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name;
		name = in.nextLine();
		System.out.println("Hello " + name);
	}
}

