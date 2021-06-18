package CollectionFramework;

import java.math.BigInteger;
import java.util.Scanner;

public class CollectionExample {
	public static void main(String[] args) {
		String firstName;
		String lastName;
		String location;
		BigInteger contact;
		int operation;

		Scanner input = new Scanner(System.in);
		ContactManager contactManager = new ContactManager();
		System.out.println("Menu");

		System.out.println("please enter 1 for add to contact");
		System.out.println("please enter 2 for update contact");
		System.out.println("please enter 3 for delete");
		System.out.println("please enter 4 for search");
		System.out.println("plaese enter 5 for view");
		System.out.println("select operation:");

		while (true) {
			operation = input.nextInt();

			switch (operation) {
			case 1: {
				System.out.println("enter firstName:");
				firstName = input.next();
				System.out.println("enter lastName:");
				lastName = input.next();
				System.out.println("enter location:");
				location = input.next();
				System.out.println("enter contact:");
				contact = input.nextBigInteger();
				Contact newContact = new Contact(firstName, lastName, location, contact);
				contactManager.add(newContact);

				break;
			}
			case 2:{
				System.out.println("enter contact:");
				contact = input.nextBigInteger();
				Contact temp = contactManager.getByContact(contact);
				System.out.println("old value are:");
				System.out.println(temp.firstName);
				System.out.println(temp.lastName);
				System.out.println(temp.location);
				System.out.println(temp.contact);

				System.out.println("Enter new value:");
				System.out.println("enter new firstName:");
				firstName = input.next();
				System.out.println("enter new lastName:");
				lastName = input.next();
				System.out.println("enter new location:");
				location = input.next();
				System.out.println("enter new contact:");
				contact = input.nextBigInteger();
				Contact newContact = new Contact(firstName, lastName, location, contact);
				newContact.setId(temp.id);
				contactManager.update(temp, newContact);
				break;
				}
			case 3: {
				System.out.println("enter number to delete:");
				contact = input.nextBigInteger();
				Contact tempContact = contactManager.getByContact(contact);
				contactManager.delete(tempContact);
				break;
			}
			case 4: {
				System.out.println("enter number to search:");
				contact = input.nextBigInteger();
				Contact oldContact = contactManager.getByContact(contact);
				System.out.println(oldContact.firstName);
				System.out.println(oldContact.lastName);
				System.out.println(oldContact.location);
				System.out.println(oldContact.contact);
				break;
			}
			case 5: {
				System.out.println("Contact details are:");
				Contact[] contactList = contactManager.view();
				for (Contact c : contactList) {
					System.out.print(c.getId() + "	");
					System.out.print(c.firstName + "	");
					System.out.print(c.lastName + "	");
					System.out.print(c.location + "	");
					System.out.println(c.contact);
				}
				break;
			}
			default:
				System.out.println("wrong choice! please enter 1234");
			}
		}
	}
}
