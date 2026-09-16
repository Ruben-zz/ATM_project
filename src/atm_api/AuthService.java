package atm_api;

public class AuthService {

	// adds a default value to the pin
	
	private int pin;
	
	public AuthService() {
		pin = 1234;
	}

	

	public boolean validatePin(int inputPin) {
		return this.pin == inputPin;

	}
}
