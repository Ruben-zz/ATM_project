package atm_api;

import java.math.BigDecimal;
import java.util.UUID;

public class CheckingAccount extends BankAccount{


	
	private BigDecimal overdraftLimit;
	
	public CheckingAccount(String owner, double AccountBalance,double overdraftLimit) {
		
		super(owner, AccountBalance);
		
		this.overdraftLimit = BigDecimal.valueOf(overdraftLimit);
		
	}	
	
	
	@Override
	public boolean withdrawFunds(double amount) {
		BigDecimal amountBD = BigDecimal.valueOf(amount);
		if (amountBD.compareTo(accountBalance.add(overdraftLimit)) > 0 || amountBD.compareTo(BigDecimal.valueOf(0)) <= 0) {
			return false;
		} else {
			accountBalance = accountBalance.subtract(amountBD);
			uuid = UUID.randomUUID();
			return true;
		}
	}
	
}
