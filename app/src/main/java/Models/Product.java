package Models;

import java.util.ArrayList;
import java.util.List;

public class Product {
    public static final int WEIGHT_BASED=0,VARIANTS_BASED=1;

    public String name;
    public int type;

    //for weight based
    public int pricePerKg;
    public float minQty;

    //for variants
    public List<Variant> variants = new ArrayList<>();

    public Product(){

    }

    //for weight based
    public Product(String name, int pricePerKg , float minQty ){
        type = WEIGHT_BASED;
        this.name=name;
        this.pricePerKg=pricePerKg;
        this.minQty=minQty;

    }

    //for variant based
    public Product(String name ){
        type = VARIANTS_BASED;
        this.name=name;

    }

    public Product(String name, List<Variant> variants) {

        type = VARIANTS_BASED;
        this.name = name;
        this.variants = variants;
    }

    public void startWeightBasedProduct(String name, int pricePerKg, float minQty) {
        type = WEIGHT_BASED;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.minQty = minQty;
    }

    public void startVariantsBasedProduct(String name) {
        type = VARIANTS_BASED;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Models.Product{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", pricePerKg=" + pricePerKg +
                ", minQty=" + minQty +
                ", variants=" + variants +
                '}';
    }


    public void fromVariantStrings(String[] vs) {
        variants = new ArrayList<>();
        for(String s : vs){

            String[] v = s.split(",");
            variants.add(new Variant(v[0], Integer.parseInt(v[1])));
        }


    }

    public String minQtyToString(){

        if(minQty < 1){
            int g = (int) (minQty * 1000);
            return g + "g";
        }

        return ((int) minQty) + "kg";
    }

    public String variantsString(){
        String variantsString = variants.toString();
        return variantsString
                .replaceFirst("\\[", "")
                .replaceFirst("]", "")
                .replaceAll(",", ", ");
    }

    public String getPrice() {
        if(type == Product.WEIGHT_BASED)
            return "\u20B9 " + pricePerKg + "/kg";

        return variantsString();


    }
}
