package product;

/***************************************************************************************
*    Title: MixIn
*    Author: George Rice
*    Date: 10/4/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P05
*
***************************************************************************************/

public class MixIn {
    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;
    }
    @Override
    public String toString() {
//        return flavor.toString() + ((amount != MixInAmount.Normal)
        return flavor.toString() + (!amount.equals(MixInAmount.Normal)
                                 ? " (" + amount + ")"
                                 : "");
    }
    private MixInFlavor flavor;
    private MixInAmount amount;
}
