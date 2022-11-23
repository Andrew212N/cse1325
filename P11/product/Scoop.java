package product;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/***************************************************************************************
*    Title: scoop
*    Author: George Rice
*    Date: 11/22/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P10
*
***************************************************************************************/

public class Scoop {
    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
        this.mixins = new ArrayList<>();
    }
    
    public Scoop(BufferedReader br) throws IOException {
        this.flavor = new IceCreamFlavor(br);
        this.mixins = new ArrayList<>();
        int numMixIns = Integer.parseInt(br.readLine());
        while(numMixIns-- > 0) mixins.add(new MixIn(br));
    }
    
    public void save(BufferedWriter bw) throws IOException {
        flavor.save(bw);
        bw.write("" + mixins.size() + '\n');
        for(MixIn mi : mixins) mi.save(bw);
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
    
    /*
    public int price()
    {
        int sum = Scoop.flavor().cost;
        for (MixIn m : mixins)
        {
            sum += m.cost;
        }
        return sum;
    }
    */
    
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;
}
