package atm_api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainAtm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// variable
		boolean isValidPin = false;

		int menuOption = 0;

		BankAccount account = null;
		int accountOptionsMenu; 
		
		String exitProgram = "N";

		// add the Scanner method from java.util.
		Scanner scan = new Scanner(System.in);

		// User Input
		System.out.println("Welcome to the Bank. Please enter the username and balance initial");

		System.out.println("Please enter the username.");
		String name = scan.nextLine();

		System.out.println("Enter the opening balance.");
		double balance = Double.parseDouble(scan.nextLine());
		
		
		do {
		
		System.out.println("Choose the account type");
		System.out.println("1.Savings account");
		System.out.println("2.Checking account");
		accountOptionsMenu = Integer.parseInt(scan.nextLine());
		
		if(accountOptionsMenu == 1) {
			account = new SavingAccount(name, balance, 2);
			((SavingAccount)account).applyInterest();
		}
		else if(accountOptionsMenu == 2){
			account = new CheckingAccount(name, balance,50);
		}
		else {
			System.err.println("ERROR!");
		}
			
		}while(accountOptionsMenu != 1 && accountOptionsMenu != 2);
		
	
		
		
		
		
		AuthService authPin = new AuthService();

		// loop to verify the PIN
		do {
			// Pin Input
			System.out.println("Please enter your 4-digit PIN");
			isValidPin = authPin.validatePin(Integer.parseInt(scan.nextLine()));

			if (isValidPin) {
				System.out.println("Authentication successful.");
			}

			else {
				System.err.println("Incorrect authentication.");
			}

		} while (!isValidPin);

		// Interactive Menu

		do {

			System.out.println("=======WELCOME TO THE BANK======");
			System.out.println("1-Check balance.");
			System.out.println("2-Withdraw funds.");
			System.out.println("3-Deposit funds.");
			System.out.println("4-Exit.");
			menuOption = Integer.parseInt(scan.nextLine());

			switch (menuOption) {
			case 1:
				// date time
				LocalDateTime dateTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				String text = dateTime.format(formatter);
				System.out.println("Your balance is: " + account.getAccountBalance());
				System.out.println("Date and time: " + text);
				break;
			case 2:
				System.out.println("Enter the amount to withdraw.");
				boolean isWithdrawalValid = account.withdrawFunds(Double.parseDouble(scan.nextLine()));
				if (isWithdrawalValid) {
					System.out.println("successful withdrawal.");
					System.out.println("Transaction ID: " + account.getUUID());
				} else {
					System.out.println("The withdrawal exceeds the funds in your account.");
				}
				break;
			case 3:
				System.out.println("Enter the amount to deposit.");
				boolean isDepositValid = account.depositFunds((Double.parseDouble(scan.nextLine())));
				if (isDepositValid) {
					System.out.println("The deposit has been processed successfully.");
					System.out.println("Transaction ID: " + account.getUUID());
				} else {
					System.out.println("Invalid deposit");
				}
				break;
			case 4:
				System.out.println("You have successfully logged out of the system.");
				exitProgram = "Y";
				break;
			default:
				System.out.println("Invalid option");

			}

		} while (exitProgram.equalsIgnoreCase("N"));

		scan.close();
	}

}
