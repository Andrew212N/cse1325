/***************************************************************************************
*    Title: Mixin
*    Author: George Rice
*    Date: 11/22/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P10
*
***************************************************************************************/

package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixIn {
    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;
    }
    public MixIn(BufferedReader br) throws IOException {
        amount = MixInAmount.valueOf(br.readLine());
        flavor = new MixInFlavor(br);
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write(amount.toString() + '\n');
        flavor.save(bw);
    }
    
    @Override
    public String toString() {
//        return flavor.toString() + ((amount != MixInAmount.Normal)
        return flavor.toString() + (!amount.equals(MixInAmount.Normal)
                                 ? " (" + amount + ")"
                                 : "");
    }
    
    public int price(MixInFlavor flavor, MixInAmount amount)
    {
        switch(MixIn)
        {
            case Light:
                return MixInFlavor.cost * 0.8;
            case Normal:
                return MixInFlavor.cost;
            case Extra:
                return MixInFlavor.cost * 1.2;
            case Drenched:
                return MixInFlavor.cost * 2;
        }
    }
    
    private MixInFlavor flavor;
    private MixInAmount amount;
}
