package product;

/***************************************************************************************
*    Title: Item
*    Author: George Rice
*    Date: 10/4/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P05
*
***************************************************************************************/

public class Item {
    public Item(String name, String description, int cost, int price) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
    }

    public String name() {return name;}
    public String description() {return description;}
    public int cost() {return cost;}
    public int price() {return price;}
    
    @Override
    public String toString() {
        return name;
    }
    protected String name;
    protected String description;
    protected int cost;
    protected int price;
} 
