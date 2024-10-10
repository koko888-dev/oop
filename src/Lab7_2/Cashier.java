package Lab7_2;

public class Cashier {
	    private DebitCard debitcard;
		private InventoryCart ic;
		//private SavingAccount save;
	    
		public Cashier() {
		}
		
		
		public void printReceipt() {
			double totalPrice = 0;
			
			//System.out.println(debitcard.getCardNumber());
			String[] s =debitcard.getCardNumber().split("-");
			
			System.out.println("\tCARD TYPE :"+ debitcard.type());
			System.out.println("\tCARD NUMBER :"+"xxx-xxx-"+s[2]);
			System.out.println("\tPumpkin Shop");
			Product[] products = ic.getAllproduct();
			for(Product product:products) {
				if(product != null) {
					totalPrice += product.getProductPrice()*product.getQulity();
					System.out.println(product+" "+(product.getProductPrice()*product.getQulity()));
				}
			}
			System.out.println("\tCARD DISCOUNT "+ debitcard.discount()*100+"\n");
			System.out.println("\t Total = \t"+totalPrice*(1-debitcard.discount())+"$");

		}

		public void doPayment(InventoryCart inventoryCart, DebitCard debitCard) {
			this.debitcard=debitCard;
			this.ic=inventoryCart;
			
		}
		
	}

