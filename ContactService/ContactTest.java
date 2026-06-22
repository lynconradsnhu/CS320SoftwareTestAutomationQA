package ContactService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ContactTest {
	
	static String id = "1";
	static String firstName = "John";
	static String lastName = "Doe";
	static String phoneNumber = "0000000000";
	static String address = "0000 unknown";

	private Contact createValidContact () { return new Contact(id, firstName, lastName, phoneNumber, address); }

	@Test 
	void testValidContactNoException () {
		assertDoesNotThrow(() -> new Contact(id, firstName, lastName, phoneNumber, address));
	}
	
	@Test
	void testNullIdException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, firstName, lastName, phoneNumber, address));
	}
	
	@Test
	void testInvalidIdException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact("000000000000", firstName, lastName, phoneNumber, address));
	}
	
	@Test
	void testNullFirstNameException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(id, null, lastName, phoneNumber, address));
				
	
		Contact contact = createValidContact();
		assertThrows(IllegalArgumentException.class, () -> contact.SetFirstName(null));
	}
	
	@Test
	void testInvalidFirstNameException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(id, "thisnameistoolong", lastName, phoneNumber, address));
				
		Contact contact = createValidContact();
		assertThrows(IllegalArgumentException.class, () -> contact.SetFirstName("thisnameistoolong"));
	}
	
	@Test 
	void testNullLastNameException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(id, firstName, null, phoneNumber, address));
				
		Contact contact = createValidContact();
		assertThrows(IllegalArgumentException.class, () -> contact.SetLastName(null));
	}
	
	@Test
	void testInvalidLastNameException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(id, firstName, "thisnameistoolong", phoneNumber, address));
				
		Contact contact = createValidContact();
		assertThrows(IllegalArgumentException.class, () -> contact.SetLastName("thisnameistoolong"));
	}
	
	@Test 
	void testNullPhoneNumberException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(id, firstName, lastName, null, address));
				
		Contact contact = createValidContact();
		assertThrows(IllegalArgumentException.class, () -> contact.SetPhoneNumber(null));
	}
	
	@Test
	void testInvalidPhoneNumberException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(id, firstName, lastName, "alskdjflaskdfjlaksfdlk", address));
				
		Contact contact = createValidContact();
		assertThrows(IllegalArgumentException.class, () -> contact.SetPhoneNumber("alskdjflaskdfjlaksfdlk"));
	}
	
	@Test 
	void testNullAddressException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(id, firstName, lastName, phoneNumber, null));
				
		Contact contact = createValidContact();
		assertThrows(IllegalArgumentException.class, () -> contact.SetAddress(null));
	}
	
	@Test
	void testInvalidAddressException () {
		assertThrows(IllegalArgumentException.class, () -> new Contact(id, firstName, lastName, phoneNumber, "notarealaddressnopeeeeeeeeeeeeeeeeeeeeeee"));
				
		Contact contact = createValidContact();
		assertThrows(IllegalArgumentException.class, () -> contact.SetAddress("notarealaddressnopeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
	}
}