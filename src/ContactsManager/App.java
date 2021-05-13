package ContactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class App {

    static List<Person> people = new ArrayList<>();
    static String directory = "./src/ContactsManager/data";
    static String fileName = "contacts.txt";
    static Path contactsTxtPath = Paths.get(directory,fileName);
    //This method will allow us to return to the main menu
    public static void mainMenu() {
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
        for(Person person : people){

            if (person.getName().equalsIgnoreCase(nameToFind)) {
                System.out.println("Name : " + person.getName() + " -- Number : " + person.getNumber());
            }else{
                System.out.println("Sorry there in no person in your contacts by that name.");
            }
        }
    }

    public static void  viewContacts(Path contactsTxtPath){
        List<String> contactInfo = new ArrayList<>();

        try {
                contactInfo = Files.readAllLines(contactsTxtPath);
                System.out.println("Here are your contacts: ");
                for(String person: contactInfo){
                    System.out.println(person);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }



            }


    //this method will add a person to our array list
    public static void addPerson() throws IOException {
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("Add a new contact name: ");

            String name = scan.nextLine();

            System.out.println("Add this contact's phone number: ");
            long number = scan.nextLong();
            Person person = new Person(name, number);


            people.add(person);

            Files.write(
                    Paths.get("./src/ContactsManager/data", "contacts.txt"),
                    Arrays.asList(name + " | " + number), // list with one item
                    StandardOpenOption.APPEND

            );
        } catch (InputMismatchException e) {
            System.out.println("this is not a number try again");
            addPerson();
        }
    }

    public static void deleteContact() throws IOException {
        List<String> people = Files.readAllLines(Paths.get("./src/ContactsManager/data", "contacts.txt"));
        List<String> newList = new ArrayList<>();

        System.out.println("Enter a contact to delete");

        Scanner sc = new Scanner(System.in);

        String nameToDelete = sc.nextLine();

        for (String person : people) {

           String[] strArr= person.split("\\|");
           System.out.println(strArr[0]);
            if (strArr[0].trim().equalsIgnoreCase(nameToDelete)) {
                continue;
            }
            newList.add(person);
        }

        Files.write(Paths.get("./src/ContactsManager/data", "contacts.txt"), newList);
    }

    public static void main(String[] args) throws IOException {

        mainMenu();
        String choice;
        do {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    viewContacts(contactsTxtPath);
                    System.out.println();
                    mainMenu();
                }
                case "2" -> {
                   addPerson();
                    System.out.println();
                    mainMenu();
                }
                case "3" -> {
                    findByName();
                    mainMenu();
                }
                case "4" -> {
                    deleteContact();
                    System.out.println();
                    mainMenu();
                }
                case "5" -> {
                    System.out.println("Goodbye");
                    System.out.println();
                    System.exit(0);
                }
                default -> System.out.println("Enter  from 1 to 5");
            }
        }while(!choice.equals("5"));
    }



}

