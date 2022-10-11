/***************************************************************************************
*    Title: Scoop
*    Author: George Rice
*    Date: 10/4/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P05
*
***************************************************************************************/

import java.util.ArrayList;

public class Scoop {
    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
        this.mixins = new ArrayList<>();
    }
    public void addMixIn(MixIn mixin) {
        mixins.add(mixin);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(flavor.toString());
        if(mixins.size() > 0) {
            String separator = " with ";
            for(MixIn m : mixins) {
                result.append(separator + m.toString());
                separator = ", ";
            }
        }
        return result.toString();
    }
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;
}
