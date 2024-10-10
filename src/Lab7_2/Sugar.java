package Lab7_2;

public class Sugar extends Product {
    public Sugar(double productPrice) {
        super(productPrice);
        this.productName = "Sugar";
    }

    
    @Override
    public String toString() {
        return this.qulity+" x "+this.productName+" "+this.unit+" Gram\t";
    }
}