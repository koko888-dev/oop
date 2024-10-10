package Lab7_2;

public class DebitCard extends Card{
	 private String cardNumber;

	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String type() {
		return "Visa";
	}

	@Override
	public double discount() {
		return 0.025;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
		
	}
	

}
