import java.util.Scanner;

public class Main {
        public static void CLS() {
        // CLEARING SCREEN COMMAND (START)
        System.out.println("\033[H\033[2J");
        System.out.flush();
        // CLEARING SCREEN COMMAND (END)
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println(" ");
            System.out.println("---------------------------------------------------------");
            System.out.println("Welcome to LoL-Coaching. Are you a Player or a Coach?\n");
            System.out.print("1.) Player\n");
            System.out.print("2.) Coach\n");
            System.out.print("3.) EXIT\n");
            System.out.print("\nEnter Your Menu Choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    CLS();

                }
                case 2 -> {
                    CLS();

                }
                case 3 -> {
                    CLS();

                }
                default -> {
                    CLS();
                    System.err.print(choice + " is not a valid option! Please try again!");
                }
            }
        } while (true);
    }

}