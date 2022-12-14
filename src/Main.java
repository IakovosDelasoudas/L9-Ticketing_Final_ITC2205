import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void CLS() {
        // CLEARING SCREEN COMMAND (START)
        System.out.println("\033[H\033[2J");
        System.out.flush();
        // CLEARING SCREEN COMMAND (END)
    }
    public static void login() throws IOException { //login function
        Store store = new Store();
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.next();
        System.out.println("Password: ");
        String password = input.next();
        boolean foundIt = false;
        for (User u:Store.getUserList())
        {
            if (u.getUsername().equals(username))
            {   // found the user that matches the username
                foundIt = true;
                if (u.authenticate(password)) {
                    System.out.println("Username: '"+username+"' logged in successfully");
//                  Store.setCurrentUser(u);
                    if (username.equals("User")){
                        showusermenu();
                    }
                    else if (username.equals("Staff1")) {
                        showstaffmenu1();
                    }
                    else if (username.equals("Staff2")) {
                        showstaffmenu2();
                    }
                }
                else
                {
                    System.err.println("Password does not match");
                    System.exit(-1);
                }
            }
        }
        if (!foundIt)
        {
            System.err.println("Username not found");
            System.exit(-1);
        }
    }
    public static int readInteger()throws IOException  { // input validation
        System.out.println("Choose your option");
        int option = 0;
        Scanner input = new Scanner(System.in);
        boolean error;
        do {
            try {
                option = input.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("That was not an integer");
                input.next(); //Throw away the wrong input
                error = true;
            }
        }
        while (error);
        return option;
    }
    public static void showMenu()throws IOException { // shows the menu and get user input from 1 to 2 thought the validation function
        while (true) {
            System.out.println("---- What do you want to so today? -----");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int option = 0;
            do {
                option = readInteger();
                switch (option) {
                    case 1:
                        CLS();
                        login();
                        break;
                    case 2:
                        System.out.println("Goodbye");
                        System.exit(0);
                    default:
                        System.out.println("Please type 1 - 2");
                }
            } while (option < 1 || option > 2);
        }
    }
    public static void showusermenu()throws IOException { // shows the menu and get user input from 1 to 2 thought the validation function
        while (true) {
            System.out.println("---- What do you want to so today? -----");
            System.out.println("1. Submit ticket");
            System.out.println("2. Exit");
            int option = 0;
            do {
                option = readInteger();
                switch (option) {
                    case 1:
                        CLS();
                        addticket();
                        break;
                    case 2:

                        System.out.println("Goodbye");
                        System.exit(0);
                    default:
                        System.out.println("Please type 1 - 2");
                }
            } while (option < 1 || option > 2);
        }
    }
    public static void showstaffmenu1()throws IOException { // shows the menu and get user input from 1 to 3 thought the validation function
        while (true) {
            System.out.println("---- What do you want to so today? -----");
            System.out.println("1. View submitted tickets");
            System.out.println("2. Search tickets either by submitted by specific user or by ticket number");
            System.out.println("3. Exit");
            int option = 0;
            do {
                option = readInteger();
                switch (option) {
                    case 1:
                        CLS();
                        viewalltickets();
                        break;
                    case 2:
                        CLS();
                        search1();
                        break;
                    case 3:
                        System.out.println("Goodbye");
                        System.exit(0);
                    default:
                        System.out.println("Please type 1 - 3");
                }
            } while (option < 1 || option > 3);
        }
    }
    public static void showstaffmenu2()throws IOException { // shows the menu and get user input from 1 to 3 thought the validation function
        while (true) {
            System.out.println("---- What do you want to so today? -----");
            System.out.println("1. View submitted tickets");
            System.out.println("2. Search tickets either by submitted by specific user or by ticket number");
            System.out.println("3. Exit");
            int option = 0;
            do {
                option = readInteger();
                switch (option) {
                    case 1:
                        CLS();
                        viewalltickets();
                        break;
                    case 2:
                        CLS();
                        search2();
                        break;
                    case 3:
                        System.out.println("Goodbye");
                        System.exit(0);
                    default:
                        System.out.println("Please type 1 - 3");
                }
            } while (option < 1 || option > 3);
        }
    }
    public static void addticket()throws IOException { // add the ticket to file and prints the things that the user types
        Ticket c1 = new Ticket();
        Scanner myObj = new Scanner(System.in);
        while (true) {
            System.out.println("---- TICKET CATEGORY -----");
            System.out.println("1. Question about product delivery...");
            System.out.println("2. Issue with delivered product...");
            int option = 0;
            do {
                option = readInteger();
                switch (option) {
                    case 1 -> {
                        System.out.println("Enter Description :");
                        String desc = myObj.nextLine();
                        c1.setDesc(desc);
                        String TicketID = RandomString();
                        c1.setTicketID(TicketID);
                        c1.setUser("User");
                        c1.setType(Ticket.Type.Type1);
                        AppendToFile(c1, TicketID);
                    }
                    case 2 -> {
                        System.out.println("Enter Description :");
                        String desc = myObj.nextLine();
                        c1.setDesc(desc);
                        String TicketID = RandomString();
                        c1.setTicketID(TicketID);
                        c1.setUser("User");
                        c1.setType(Ticket.Type.Type2);
                        AppendToFile(c1, TicketID);
                    }
                    default -> System.out.println("Please type 1 - 2");
                }
            } while (option < 1 || option > 2);
        }
    }

    private static void AppendToFile(Ticket c1, String ticketID) { //appends data in a file
        try
        {
            String filename= "Tickets.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(c1+ "\n");//appends the string to the file
            fw.close();
            System.out.println("Your TickedID is: " + ticketID);
            System.exit(0);
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static String RandomString() { // generates a random string to be used as a ticket id
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static void viewalltickets() throws IOException{ // displays all contents of tickets.txt
        try (BufferedReader br = new BufferedReader(new FileReader("Tickets.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    public static void search1() throws IOException {

        String[] words=null;  //Initialize the word Array
        FileReader fr = new FileReader("Tickets.txt");  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        while((s=br.readLine())!=null)   //Reading Content from the file
        {
            words=s.split(",");  //Split the word using comma
            for (String word : words)
            {
                if (word.equals("Type1"))   //Search for the given word
                {
                    System.out.println(s);
                }
            }
        }
    }
    public static void search2() throws IOException {

        String[] words=null;  //Initialize the word Array
        FileReader fr = new FileReader("Tickets.txt");  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        while((s=br.readLine())!=null)   //Reading Content from the file
        {
            words=s.split(",");  //Split the word using comma
            for (String word : words)
            {
                if (word.equals("Type2"))   //Search for the given word
                {
                    System.out.println(s);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
            showMenu();
    }
}