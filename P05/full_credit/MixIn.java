public class MixIn
{
    private MixInFlavor flavor;
    private MixInAmount amount;
    
    public MixInFlavor(MixInFlavor flavor, MixInAmount amount)
    {
        this.flavor = flavor;
        this.amount = amount;
    }
    
    public String toString()
    {
        if (amount = "Normal")
            return "" + MixInFlavor + " ";
        else
            return "" + MixInFlavor + "' " + MixInAmount + " '";
    }
}
