import java.util.ArrayList;

public class Scoop
{
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mix;
    
    public Scoop (IceCreamFlavor flavor)
    {
        this.flavor = flavor;
        mix = new ArrayList<MixIn>();
    }
    
    public void addMixIn(MixIn mixins[])
    {
        this.mix.addAll(mix);
    }
    
    @Override
    public String toString()
    {
        return "" + flavor + "with " + mix + " ";
    } 
}
