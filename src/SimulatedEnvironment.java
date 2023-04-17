import java.util.Scanner;

public class SimulatedEnvironment {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Team 7's Triage Classification System!");
        System.out.println("When prompted, you may select a one of the experiments against which you can test this system.");
        System.out.println("Each experiment will last 20 seconds.");
        System.out.println("When you wish to exit, enter any character.");
        String input = "";
        while(true) {
            System.out.println("Please enter a number corresponding with the experiment to run.");
            System.out.println("1. Prioritizing two patients");
            System.out.println("2. Prioritizing four patients");
            System.out.println("3. Prioritizing six patients");
            System.out.println("4. Prioritizing one patient, then adding one more after 1 second");
            System.out.println("5. Prioritizing two patients, then adding one per second until there are four patients in total");
            System.out.println("6. Prioritizing three patients, then adding one per second until there are six patients in total");

            input = scan.nextLine();

            if(input.equals("1")) {
                System.out.println("Running Experiment 1");
                // Begin by initializing two PatientReadings objects. Allow the user to enter SpO2 and bp values.
                
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
            else if(input.equals("5")) {
                System.out.println("Running Experiment 5");
            }
            else if(input.equals("6")) {
                System.out.println("Running Experiment 6");
            }
            else {
                break;
            }
        }
        System.out.println("Goodbye!");
    }
}
