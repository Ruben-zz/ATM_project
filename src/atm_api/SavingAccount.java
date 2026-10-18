package atm_api;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingAccount extends BankAccount {
	
	private BigDecimal interesRate;
	
	
	
	public SavingAccount(String owner, double AccountBalance,double interesRate) {
		
		super(owner, AccountBalance);
		
		this.interesRate = BigDecimal.valueOf(interesRate);
		
		
	}
	
	public void applyInterest() {
		
		interesRate = interesRate.divide(BigDecimal.valueOf(100));
		
		interesRate = interesRate.divide(BigDecimal.valueOf(12),5,RoundingMode.HALF_EVEN);
		
		interesRate = interesRate.multiply(accountBalance);
		
		accountBalance = accountBalance.add(interesRate);
		
		accountBalance = accountBalance.setScale(2, RoundingMode.HALF_EVEN);
	}
	
	
	
}
