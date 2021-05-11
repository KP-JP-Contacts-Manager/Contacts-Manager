package ContactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Person> people = new ArrayList<>();

        //this method will add a person to our array list
    public static void addPerson() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Add a new contact name: ");
        String name = scan.nextLine();
        System.out.println("Add this contact's phone number: ");
        String number= scan.nextLine();

        Person person = new Person(name, number);

        Files.write(
                Paths.get("./src/ContactsManager/data", "contacts.txt"),
                Arrays.asList(name +" | " +number + " |"), // list with one item
                StandardOpenOption.APPEND
        );


    }
    //This method will allow us to return to the main menu
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello user, Welcome to your Contact Manager.");
        System.out.println();
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");

        System.out.println("Enter an option (1, 2, 3, 4, or 5 ) :");
    }
    //This method will allow us to search a user by their name and return the output
    public static void findByName(){
        System.out.println("Enter a name to search");
        Scanner sc = new Scanner(System.in);
        String nameToFind = sc.nextLine();
        for(Person person:people){
            if (person.getName().equalsIgnoreCase(nameToFind)) {
                System.out.println(person);
            }else{
                System.out.println("Sorry there in no person in your contacts by that name.");
            }
        }
    }
//    This meathod
    public static void deleteContacts(){
        System.out.println("Which contact would you like to delete?");
        Scanner sc = new Scanner(System.in);
        String deleteName = sc.nextLine();
        Path filepath = Paths.get("data", "contact.txt");

        if (person.getName().equalsIgnoreCase(deleteName)) {


        }else{
                System.out.println("Sorry there in no person in your contacts by that name.");
            }
//        }
        System.out.println("Person you deleted was " + deleteName);
    }

    public static void main(String[] args) throws IOException {

        deleteContacts();
        //basic UI main menu

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
