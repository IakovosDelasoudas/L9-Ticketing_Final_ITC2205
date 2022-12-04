import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void CLS() {
        // CLEARING SCREEN COMMAND (START)
        System.out.println("\033[H\033[2J");
        System.out.flush();
        // CLEARING SCREEN COMMAND (END)
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
    public static void showMenu()throws IOException {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int option = 0;
            do {
                option = readInteger();
                switch (option) {
                    case 1:
                        CLS();
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
    public static void showusermenu()throws IOException {
        while (true) {
        System.out.println("---- What do you want to so today? -----");
        System.out.println("1. Submit ticket");
        System.out.println("2. Search ticket");
        System.out.println("3. Exit");
        int option = 0;
            do {
            option = readInteger();
                switch (option) {
                    case 1:
                        //Submitticket();
                        break;
                    case 2:
                        //search();
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

    public static void main(String[] args) throws IOException {
            showMenu();
    }
}