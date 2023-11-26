import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress + "\n";
    }
}

class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
        System.out.println("Contact removed successfully.");
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void saveContactsToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadContactsFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            contacts = (ArrayList<Contact>) ois.readObject();
            System.out.println("Contacts loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class AddressBookSystem {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book System");
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Save contacts to file");
            System.out.println("6. Load contacts from file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact(addressBook, scanner);
                    break;
                case 2:
                    removeContact(addressBook, scanner);
                    break;
                case 3:
                    searchContact(addressBook, scanner);
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    saveContactsToFile(addressBook, scanner);
                    break;
                case 6:
                    loadContactsFromFile(addressBook, scanner);
                    break;
                case 7:
                    System.out.println("Exiting Address Book System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, emailAddress);
        addressBook.addContact(contact);
    }

    private static void removeContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter the name of the contact to remove: ");
        String nameToRemove = scanner.nextLine();
        addressBook.removeContact(nameToRemove);
    }

    private static void searchContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter the name of the contact to search: ");
        String nameToSearch = scanner.nextLine();
        Contact foundContact = addressBook.searchContact(nameToSearch);
        if (foundContact != null) {
            System.out.println("Contact found:\n" + foundContact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void saveContactsToFile(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter the file name to save contacts: ");
        String fileName = scanner.nextLine();
        addressBook.saveContactsToFile(fileName);
    }

    private static void loadContactsFromFile(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter the file name to load contacts: ");
        String fileName = scanner.nextLine();
        addressBook.loadContactsFromFile(fileName);
    }
}
