package Lab7_2;

public class Coffee extends Product {

    public Coffee(double productPrice) {
        super(productPrice);
        this.productName = "Coffee";
    }

    
    @Override
    public String toString() {
        return this.qulity+" x "+this.productName+" "+this.unit+" Gram\t";
    }
    
}