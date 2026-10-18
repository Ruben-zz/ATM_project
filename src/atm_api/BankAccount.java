package atm_api;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount {
	
	protected UUID uuid;

	protected BigDecimal accountBalance;

	protected String owner;

	
	public BankAccount(String owner, double accountBalance) {

		this.owner = owner.toUpperCase().strip();

		this.accountBalance = BigDecimal.valueOf(accountBalance);
	}

	
	public String getOwner() {
		return owner;
	}

	public UUID getUUID() {

		return uuid;

	}

	public boolean depositFunds(double amount) {

		if (amount <= 0) {
			return false;
		} else {
			accountBalance = accountBalance.add(BigDecimal.valueOf(amount));
			uuid = UUID.randomUUID();
			return true;
		}

	}

	public BigDecimal getAccountBalance() {
		return accountBalance;

	}

	public boolean withdrawFunds(double amount) {
		BigDecimal amountBD = BigDecimal.valueOf(amount);
		if (amountBD.compareTo(accountBalance) > 0 || amount <= 0) {
			return false;
		} else {
			accountBalance = accountBalance.subtract(amountBD);
			uuid = UUID.randomUUID();
			return true;
		}

	}

}
