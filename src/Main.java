import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void CLS() {
        // CLEARING SCREEN COMMAND (START)
        System.out.println("\033[H\033[2J");
        System.out.flush();
        // CLEARING SCREEN COMMAND (END)
    }
    public void login() {
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
                    System.out.println("Username: "+username+" login successful");
//                    Store.setCurrentUser(u);
                }
                else
                {
                    System.out.println("password does not match");
                }
            }
        }
        if (!foundIt)
        {
            System.out.println("Username not found");
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
    public static void showMenu()throws IOException { // shows the menu and get user input from 1 to 5 thought the validation fucntion
        String nameToSearch;
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
                        System.out.println("1. Login");
                        //login();
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
    public static void main(String[] args) throws IOException {
            showMenu();
    }
}