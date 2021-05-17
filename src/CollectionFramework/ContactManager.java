package CollectionFramework;

import java.math.BigInteger;
import java.util.ArrayList;

public class ContactManager {
	ArrayList<Contact> contacts;

	public ContactManager() {
		contacts=new ArrayList<Contact>();
	}
	
	public void add(Contact contact) {
		contacts.add(contact);
	}
	
	public Contact getByContact(BigInteger number) {
		return contacts.stream().filter(o->o.getContact().equals(number)).findFirst().orElse(new Contact());
	}
	
	public void update(Contact oldContact, Contact newContact) {
		contacts.set(contacts.indexOf(oldContact), newContact);
	}
	
	public void delete(Contact contact) {
		contacts.remove(contact);
	}
	
	public Contact[] view(){
		return contacts.toArray(new Contact[0]);
	}
}
