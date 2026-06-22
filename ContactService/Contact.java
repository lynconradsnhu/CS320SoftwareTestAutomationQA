package ContactService;
public class Contact {
	// Properties
	private final String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// Create an instance of the Contact class
	public Contact (String id, String firstName, String lastName, String phoneNumber, String address)
	{
		// Validation
		if (id == null) throw new IllegalArgumentException("Contact id must have a value.");
		if (id.length() > 10) throw new IllegalArgumentException("Contact id must have 10 or less characters.");
		ValidateFirstName(firstName);
		ValidateLastName(lastName);
		ValidatePhoneNumber(phoneNumber);
		ValidateAddress(address);
		
		// Set properties
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		
		return;
	}
	
	// Getters
	public String GetId () { return this.id; };
	public String GetFirstName () { return this.firstName; };
	public String GetLastName () { return this.lastName; };
	public String GetPhoneNumber () { return this.phoneNumber; };
	public String GetAddress () { return this.address; };
	
	// Setters
	public void SetFirstName (String firstName) { ValidateFirstName(firstName); this.firstName = firstName; }
	public void SetLastName (String lastName) { ValidateLastName(lastName); this.lastName = lastName; }
	public void SetPhoneNumber (String phoneNumber) { ValidatePhoneNumber(phoneNumber); this.phoneNumber = phoneNumber; }
	public void SetAddress (String address) { ValidateAddress(address); this.address = address; }
	
	// Validators
	private void ValidateFirstName (String firstName) {
		if (firstName == null) throw new IllegalArgumentException("First name must have a value.");
		if (firstName.length() > 10) throw new IllegalArgumentException("First name must have 10 or less characters.");
	}
	private void ValidateLastName (String lastName) {
		if (lastName == null) throw new IllegalArgumentException("Last name must have a value.");
		if (lastName.length() > 10) throw new IllegalArgumentException("Last name must have 10 or less characters.");
	}
	private void ValidatePhoneNumber (String phoneNumber) {
		if (phoneNumber == null) throw new IllegalArgumentException("Phone number must have a value.");
		if (phoneNumber.length() != 10) throw new IllegalArgumentException("Last name must have exactly 10 characters.");
	}
	private void ValidateAddress (String address) {
		if (address == null) throw new IllegalArgumentException("Address must have a value.");
		if (address.length()  > 30) throw new IllegalArgumentException("Address must have 30 or less characters.");
	}
}