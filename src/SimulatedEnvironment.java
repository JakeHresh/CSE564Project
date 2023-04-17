import java.util.Scanner;

public class SimulatedEnvironment {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        PatientReadings[] patArr = null;

        String input = "";

        System.out.println("Welcome to Team 7's Triage Classification System!");
        System.out.println("When prompted, you may select a one of the experiments against which you can test this system.");
        System.out.println("Each experiment will last 20 seconds.");
        System.out.println("When you wish to exit, enter any character.");

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
                patArr = new PatientReadings[2];
                initializePatientCollection(patArr, patArr.length);
            }
            else if(input.equals("2")) {
                System.out.println("Running Experiment 2");
                patArr = new PatientReadings[4];
                initializePatientCollection(patArr, patArr.length);
            }
            else if(input.equals("3")) {
                System.out.println("Running Experiment 3");
                patArr = new PatientReadings[6];
                initializePatientCollection(patArr, patArr.length);
            }
            else if(input.equals("4")) {
                System.out.println("Running Experiment 4");
                patArr = new PatientReadings[2];
                initializePatientCollection(patArr, patArr.length);
                // To indicate which patients are to be prioritized, the read value will be initialized accordingly.
                patArr[1].setRead(false);
            }
            else if(input.equals("5")) {
                System.out.println("Running Experiment 5");
                patArr = new PatientReadings[4];
                initializePatientCollection(patArr, patArr.length);
                patArr[2].setRead(false);
                patArr[3].setRead(false);
            }
            else if(input.equals("6")) {
                System.out.println("Running Experiment 6");
                patArr = new PatientReadings[4];
                initializePatientCollection(patArr, patArr.length);
                patArr[3].setRead(false);
                patArr[4].setRead(false);
                patArr[5].setRead(false);
            }
            else {
                break;
            }
        }
        System.out.println("Goodbye!");
    }

    public static void initializePatientCollection(PatientReadings[] patArr, int patientCount) {
        for(int i = 0; i < patientCount; i++)
        {
            patArr[i] = new PatientReadings();
            patArr[i].setId(i);
            patArr[i].setRead(true);
            System.out.println("Set the measured systolic blood pressure for patient " + patArr[i].getId() + ".");
            patArr[i].setSystolic(scan.nextInt());
            System.out.println("Set the measured diastolic blood pressure for patient " + patArr[i].getId() + ".");
            patArr[i].setDiastolic(scan.nextInt());
            System.out.println("Set the measured amount of red light for calculating SpO2.");
            patArr[i].setRed(scan.nextInt());
            System.out.println("Set the measured amount of infrared light for calculating SpO2.");
            patArr[i].setIR(scan.nextInt());
        }
    }
}
