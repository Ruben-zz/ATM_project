package atm_api;

public class AuthService {
	
		//adds a default value to the pin
	public AuthService() {
	
		pin = 1234;
	}
	
	
	private int pin;
	
	
	
	public boolean validatePin(int inputPin) {
		return this.pin == inputPin;
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

