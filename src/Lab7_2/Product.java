package Lab7_2;

public class Product {
	protected String productCode;
	protected String productName;
	protected double productPrice;
    protected double unit;
	protected int qulity;
	
	
	
	public Product(String productCode, String productName, double productPrice) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.qulity = 0;
	}


    public Product(double productPrice){
        this.productPrice = productPrice;
		this.qulity = 0;
    }



    
	
	

	public int getQulity() {
		return qulity;
	}


	public void setQulity(int qulity) {
		this.qulity += qulity;
	}


	public String getProductCode() {
		return productCode;
	}



	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


    public double getUnit() {
        return unit;
    }

	@Override
	public String toString() {
		return "";
	}

	public void setWeight(double unit){
        this.unit = unit;
    }


	public void setVolumn(double unit){
        this.unit = unit;
    }

}
