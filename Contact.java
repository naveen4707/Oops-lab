import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> contacts = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Contact Management ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear input

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = sc.nextLine();
                    contacts.add(name);
                    System.out.println("Contact added.");
                    break;

                case 2:
                    System.out.println("Contacts List:");
                    for (String contact : contacts) {
                        System.out.println(contact);
                    }
                    break;

                case 3:
                    System.out.print("Enter name to delete: ");
                    String delName = sc.nextLine();
                    if (contacts.remove(delName)) {
                        System.out.println("Contact deleted.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}
