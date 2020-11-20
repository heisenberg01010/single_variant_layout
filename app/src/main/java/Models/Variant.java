
package Models;


public class Variant {

    public String name;
    public int price;

    public Variant(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\u20B9 "+" "+price;
    }

    public String nameString()
    { return name +"\u20B9 " +price;}

}
