package Lab7_2;

public class InventoryCart {
    private int itemlimit;
	private int count;
	private int last;
	private Product[] products;
	private int[] countProduct;
	
	
	public InventoryCart(int itemlimit) {
		this.itemlimit = itemlimit;
		this.products = new Product[itemlimit];
		this.count = 0;
	}
	
	
	
	public void addProduct(Product product) {
        boolean notAdd = true;
        if(this.count < this.itemlimit) {
	        for(int i=0;i<=this.last;i++){
	            if((this.products[i] != null) && (this.products[i].getProductName().equals(product.getProductName()))){
	                this.products[i].setQulity(1);
	            	this.products[count] = null;
	                this.last = count;
	                count++;
	                notAdd = false;
	                break;
	            }
	        }
        }

		if(this.count < this.itemlimit && notAdd) {
			this.products[count] = product;
            this.products[count].setQulity(1);
			this.last = this.count;
			this.count++;
		}
	}
	
	public Product getProduct() {
		if(this.last >=0) {
			Product returnProduct = this.products[this.last];
			this.products[this.last] = null;
			this.last--;
			this.count = this.last;
			return returnProduct;
		}
		return null;
	}
	
	public Product[] getAllproduct() {
		Product[] returnProducts = this.products;
		this.products = new Product[this.itemlimit];
		return returnProducts;
	}
}

