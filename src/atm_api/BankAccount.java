package atm_api;

public class BankAccount {
	public BankAccount(String owner, double accountBalance) {
		
	
		this.owner = owner.toUpperCase().strip();;
		
		this.accountBalance = accountBalance;
	}
	
	
	
	
	private double accountBalance;
	
	private String owner;
	
	public String getOwner() {
		return owner;
	}
	
	
	public boolean depositFunds(double amount) {
		
		if (amount <= 0) {
			return false;
		}
		else {
			accountBalance += amount;
			return true;
		}
		
	}
	
	public double getAccountBalance() {
		return accountBalance;
		
	}
	
	
	
	public boolean withdrawFunds(double amount) {
		if(amount > accountBalance || amount <= 0) {
			return false;
		}
		else {
			accountBalance -= amount;
			return true;
		}
		
		
	}
	
	
	
}
