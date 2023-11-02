import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Contact Manager Menu:");
            System.out.println("1. Add a contact");
            System.out.println("2. View contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        System.out.println("Contacts:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Contact " + (i + 1) + ":\n" + contacts.get(i));
        }
    }

    private static void editContact() {
        System.out.print("Enter the index of the contact you want to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 1 && index <= contacts.size()) {
            Contact contact = contacts.get(index - 1);
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new email address: ");
            String email = scanner.nextLine();

            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid index. No contact found.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter the index of the contact you want to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 1 && index <= contacts.size()) {
            Contact contact = contacts.remove(index - 1);
            System.out.println("Contact deleted:\n" + contact);
        } else {
            System.out.println("Invalid index. No contact found.");
        }
    }
}
