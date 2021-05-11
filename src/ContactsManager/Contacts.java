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

public class Contacts {


        public static void main(String[] args) throws IOException{
            //Here we have declared the directory and the fileName
            String directory = "./src/ContactsManager/data";
            String fileName = "contacts.txt";

            //Return a Path that corresponds to the passed string, or multiple strings representing directories and files
            Path dataDirectory = Paths.get(directory);
            Path dataFile = Paths.get(directory,fileName);

            //if file paths of the directory do not exist then create one
            if (Files.notExists((dataDirectory))) {
                Files.createDirectories(dataDirectory);

            }
            //if file paths of the data file doesn't exist then create one.
            if(! Files.exists(dataFile)){
                Files.createFile(dataFile);
            }

            //creating path to out created directory contacts.txt
            Path contactsTxtPath = Paths.get(directory,fileName);

            //Start creating array to push our contacts into
            List<String> contacts = Arrays.asList("Kelvon Patterson", "John Pierce");

            //basic UI main menu
            Scanner sc = new Scanner(System.in);
            System.out.println("1. View contacts");
            System.out.println("2. Add a new contact");



        }

    }
