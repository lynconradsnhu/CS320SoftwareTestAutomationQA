package ContactService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestInstance(Lifecycle.PER_CLASS)
public class ContactServiceTest {
	
	static String firstName = "John";
	static String lastName = "Doe";
	static String phoneNumber = "0000000000";
	static String address = "0000 unknown";
	
	ContactService contactService;

	@BeforeEach
	void setup () {
		contactService = new ContactService();
		contactService.addContact(firstName, lastName, phoneNumber, address);
	};
	
	@Test
	void testAddContact () {
		assertEquals(1, contactService.contacts.size());
        assertEquals(1, contactService.contactSequence);
        
		Contact contact = contactService.contacts.getFirst();
		assertEquals("1", contact.GetId());
		assertEquals(firstName, contact.GetFirstName());
		assertEquals(lastName, contact.GetLastName());
		assertEquals(phoneNumber, contact.GetPhoneNumber());
		assertEquals(address, contact.GetAddress());
	};
	
	@Test
	void testDeleteContact () {
		assertDoesNotThrow(() -> contactService.deleteContact("1"));
		assertEquals(0, contactService.contacts.size());
	};
	
	@Test
	void testUpdateFirstName () {
		assertDoesNotThrow(() -> contactService.updateFirstName("1", "newName"));
		assertEquals("newName", contactService.contacts.getFirst().GetFirstName());
	};
	
	@Test
	void testUpdateLastName () {
		assertDoesNotThrow(() -> contactService.updateLastName("1", "newName"));
		assertEquals("newName", contactService.contacts.getFirst().GetLastName());
	};
	
	@Test
	void testUpdatePhoneNumber () {
		assertDoesNotThrow(() -> contactService.updatePhoneNumber("1", "1111111111"));
		assertEquals("1111111111", contactService.contacts.getFirst().GetPhoneNumber());
	};
	
	@Test
	void testUpdateAddress () {
		assertDoesNotThrow(() -> contactService.updateAddress("1", "1111 unknown"));
		assertEquals("1111 unknown", contactService.contacts.getFirst().GetAddress());
	};
}