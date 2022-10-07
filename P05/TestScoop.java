import java.util.Scanner;
import java.util.ArrayList;

public class TestScoop
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        ArrayList<IceCreamFlavor> newflavor = new ArrayList<IceCreamFlavor>();
        ArrayList<MixIn> newmixin = new ArrayList<MixIn>();
        
        System.out.print("================\nIce Cream Tester\n================\n");
        String choice = "y";
        System.out.print("Create new (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit? ");
        while (!(choice.equals('q')))
        {
            choice = in.nextLine();
            
            switch (choice)
            {
                case "m":
                    System.out.print("\nCreating new Mixin!\n\nName? ");
                    String a = in.nextLine();
                    System.out.print("Description? ");
                    String b = in.nextLine();
                    System.out.print("Price? ");
                    int c = in.nextInt();
                    System.out.print("Cost? ");
                    int d = in.nextInt();
                    
                    MixInFlavor newmixinflavor = new MixInFlavor(a,b,c,d);
                    newmixin.add(new MixIn(newmixinflavor, MixInAmount.Normal));
                    System.out.print("\nMixin Created!\n\n");
                    System.out.print("Create new (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit? ");
                    break;
                case "i":
                    System.out.print("\nCreating new Ice Cream Flavor!\n\nName? ");
                    String e = in.nextLine();
                    System.out.print("Description? ");
                    String f = in.nextLine();
                    System.out.print("Price? ");
                    int g = in.nextInt();
                    System.out.print("Cost? ");
                    int h = in.nextInt();
                    
                    newflavor.add(new IceCreamFlavor(e,f,g,h));
                    System.out.print("\nFlavor Created!\n");
                    System.out.print("Create new (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit? ");
                    break;
                case "s":
                    System.out.print("\nCreating new Scoop!\n");
                    for(int i=0; i<newflavor.size(); i++)
                    {
                        System.out.print("(" + i + ") " + newflavor.get(i).name() + "\n");
                    }
                    if(newflavor.size() == 0)
                    {
                        System.out.print("No Flavors avaliable.\n");
                        System.out.print("Create new (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit? ");
                        break;
                    }
                    System.out.print("Flavor? ");
                    int flavorchoice = in.nextInt();
                    String flavor = newflavor.get(flavorchoice).name().toString();
                    
                    for(int i=0; i<newmixin.size(); i++)
                    {
                        System.out.print("(" + i + ") " + newmixin.get(i) + "\n");
                    }
                    if(newmixin.size() == 0)
                    {
                        System.out.print("No MixIns avaliable.\n");
                        System.out.println("Ice Cream Scoop: " + flavor);
                        System.out.print("Create new (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit? ");
                        break;
                    }
                    else
                    {
                        System.out.print("MixIns? ");
                        int mixinchoice = in.nextInt();
                        String mixin = newmixin.get(mixinchoice).toString();
                        System.out.println("Ice Cream Scoop: " + flavor + " with " + mixin);
                        System.out.print("Create new (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit? ");
                        break;
                    }
                case "q":
                    System.out.print("Exiting...\n");
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
