package Lab7_2;

public class Milk extends Product{

    public Milk(double productPrice) {
        super(productPrice);
        this.productName = "Milk";
    }

    


    @Override
    public String toString() {
        return this.qulity+" x "+this.productName+" "+this.unit+" CC\t";
    }
    
}