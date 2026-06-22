package ContactService;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
	// Properties 
	public List<Contact> contacts = new ArrayList<Contact>();
	public int contactSequence = 0; // assumes the number of contacts will never exceed a billion
	
	public void addContact (String firstName, String lastName, String phoneNumber, String address) {
		String id = String.valueOf(contactSequence + 1);
		Contact contact = new Contact(id, firstName, lastName, phoneNumber, address);
		
		// if creating the Contact succeeds
		contactSequence++;
		contacts.add(contact);
	}
	
	public void deleteContact (String contactId) {
		contacts.removeIf(x -> x.GetId().equals(contactId));
	}
	
	public void updateFirstName (String contactId, String firstName) {
		Contact contact = contacts.stream().filter(x -> x.GetId().equals(contactId)).findFirst().orElse(null);
		contact.SetFirstName(firstName);
	}
	
	public void updateLastName (String contactId, String lastName) {
		Contact contact = contacts.stream().filter(x -> x.GetId().equals(contactId)).findFirst().orElse(null);
		contact.SetLastName(lastName);
	}
	
	public void updatePhoneNumber (String contactId, String phoneNumber) {
		Contact contact = contacts.stream().filter(x -> x.GetId().equals(contactId)).findFirst().orElse(null);
		contact.SetPhoneNumber(phoneNumber);
	}
	
	public void updateAddress (String contactId, String address) {
		Contact contact = contacts.stream().filter(x -> x.GetId().equals(contactId)).findFirst().orElse(null);
		contact.SetAddress(address);
	}
}