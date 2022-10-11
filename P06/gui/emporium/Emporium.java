package emporium;
import java.util.ArrayList;
import product.IceCreamFlavor;
import product.Item;
import product.MixIn;
import product.MixInAmount;
import product.MixInFlavor;
import product.Scoop;

public class Emporium
{
    private ArrayList<MixInFlavor> mixins = new ArrayList<>();
    private ArrayList<IceCreamFlavor> flavors = new ArrayList<>();
    private ArrayList<Scoop> scoops = new ArrayList<>();
    
    public void addMixInFlavor(MixInFlavor flavor)
    {
        mixins.add(flavor);
    }
    
    public void addIceCreamFlavor(IceCreamFlavor flavor)
    {
        flavors.add(flavor);
    }
    
    public void addScoop(Scoop scoop)
    {
        scoops.add(scoop);
    }
    
    public void mixInFlavors()
    {
        mixins.toArray();
    }
    
    public void iceCreamFlavors()
    {
        flavors.toArray();
    }
    
    public void scoops()
    {
        scoops.toArray();
    }
}
