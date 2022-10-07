public class MixIn
{
    private MixInFlavor flavor;
    private MixInAmount amount;
    
    public MixIn(MixInFlavor flavor, MixInAmount amount)
    {
        this.flavor = flavor;
        this.amount = amount;
    }
    
    public String toString()
    {
        if (amount.equals(MixInAmount.Normal))
            return "" + flavor.name() + " ";
        else
            return "" + flavor.name() + " ' " + amount + " '";
    }
}
