package ContactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Person> people = new ArrayList<>();

    public static void addPerson() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Add a new contact name: ");
        String name = scan.nextLine();
        System.out.println("Add this contact's phone number: ");
        String number= scan.nextLine();

        Person person = new Person(name, number);

        Files.write(
                Paths.get("./src/ContactsManager/data", "contacts.txt"),
                Arrays.asList(name +" | " +number), // list with one item
                StandardOpenOption.APPEND
        );


    }

    public static void main(String[] args) throws IOException {


        //basic UI main menu
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello user, Welcome to your Contact Manager.");
        System.out.println();
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4, or 5) :");

        addPerson();

        String choice;
//        do {
//            choice = sc.nextLine();
//            switch (choice) {
//                case "1":
//                    addPerson();
//                    break;
//                case "2":
//                    findPerson();
//                    break;
//                case "3":
//                    System.out.println(people);
//                    System.out.println();
//                    showMainMenu();
//                    break;
//                case "4":
//                    deletePerson();
//                    break;
//                case "5":
//                    System.exit(0);
//                    break;
//
//                default:
//                    System.out.println("Enter  from 1 to 4");
//            }
//        }while(!choice.equals("5"));
//    }


    }
}
