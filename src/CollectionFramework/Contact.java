package CollectionFramework;

import java.math.BigInteger;
import java.util.UUID;

public class Contact {
	UUID id;
	String firstName;
	String lastName;
	String location;
	BigInteger contact;
	
	public Contact() {
		
	}
	
	public Contact(String firstName,String lastName,String location,BigInteger contact) {
		this.id=UUID.randomUUID();
		this.firstName=firstName;
		this.lastName=lastName;
		this.location=location;
		this.contact=contact;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id=id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public BigInteger getContact() {
		return contact;
	}
	
	public void setContact(BigInteger contact) {
		this.contact = contact;
	}
}
