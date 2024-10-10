package Lab7_2;

public class SavingAccount extends BaseAccount{
	//private Card card;
	private FixedSalary fixedsalary;
	private DebitCard debitcard;
	
	public SavingAccount(FixedSalary employeeA) {
		this.fixedsalary = employeeA;
		this.debitcard = new DebitCard();
		this.debitcard.setCardNumber(employeeA.securityNumber);
		this.fixedsalary.debitcard=this.debitcard;
		
	}

	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		return false;
	}






}
