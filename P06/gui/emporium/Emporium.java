import java.util.ArrayList;

public class Emporium
{
    private ArrayList<MixInFlavor> mixins = new ArrayList<>();
    private ArrayList<IceCreamFlavor> flavors = new ArrayList<>();
    private ArrayList<Scoop> scoops = new ArrayList<>();
    
    public void addMixInFlavor(MixInFlavor flavor)
    {
        mixins.add(new MixInFlavor(flavor));
    }
    
    public void addIceCreamFlavor(IceCreamFlavor flavor)
    {
        flavors.add(new IceCreamFlavor(flavor));
    }
    
    public void addScoop(Scoop scoop)
    {
        scoops.add(new Scoop(scoop));
    }
    
    public void mixInFlavors()
    {
        mixInFlavors.toArray();
    }
    public Object[] iceCreamFlavors()
    {
        iceCreamFlavors.toArray();
    }
    public Object[] scoops()
    {
        scoops.toArray();
    }
}
