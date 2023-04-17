import java.util.Scanner;

public class SimulatedEnvironment {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Team 7's Triage Classification System!");
        System.out.println("When prompted, you may select a one of the experiments against which you can test this system.");
        System.out.println("When you wish to exit, enter any character.");
        String input = "";
        while(true) {
            System.out.println("Please enter a number corresponding with the experiment to run.");
            System.out.println("1. Experiment 1");
            System.out.println("2. Experiment 2");
            System.out.println("3. Experiment 3");
            System.out.println("4. Experiment 4");

            input = scan.nextLine();

            if(input.equals("1")) {
                System.out.println("Running Experiment 1");
            }
            else if(input.equals("2")) {
                System.out.println("Running Experiment 2");
            }
            else if(input.equals("3")) {
                System.out.println("Running Experiment 3");
            }
            else if(input.equals("4")) {
                System.out.println("Running Experiment 4");
            }
            else {
                break;
            }
        }
        System.out.println("Goodbye!");
    }
}
