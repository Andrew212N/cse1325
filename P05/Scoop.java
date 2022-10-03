import java.util.ArrayList;

public class Scoop
{
    private IceCreamFlavor flavor;
    private MixIn mixins[] = NaN;
    
    public Scoop (IceCreamFlavor flavor)
    {
        this.flavor = flavor;
        ArrayList<MixIn> toppings = new ArrayList<MixIn>();
    }
    
    public void addMixIn(MixIn mixins[])
    {
        toppings.add(mixins);
    }
    
    public String toString()
    {
        String addons[];
        for (int i = 0; i < toppings.size(); i++)
        {
            String s = toppings.get(i);
            addons.concat(s).concat(", ");
        }
        return "" + flavor +"with " + addons + " ";
    }
    
}
