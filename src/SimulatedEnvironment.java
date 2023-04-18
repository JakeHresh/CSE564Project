import java.util.Scanner;

class ThreadClass implements Runnable {
    int currentRound = 0;
    PatientReadings patient = null;
    SphygmomanometerSensor bpSensor = null;
    SphygmomanometerCoordinator bpCoordinator = null;
    PulseOximeterSensor SpO2Sensor = null;
    OxygenCoordinator SpO2Coordinator = null;
    PatientDataWriter dataWriter = null;
    PatientAccumulator patientAccumulator = null;

    public ThreadClass(int currentRound, PatientReadings patient, SphygmomanometerSensor bpSensor, SphygmomanometerCoordinator bpCoordinator, PulseOximeterSensor SpO2Sensor, OxygenCoordinator SpO2Coordinator, PatientDataWriter dataWriter, PatientAccumulator patientAccumulator) {
        this.currentRound = currentRound;
        this.patient = patient;
        this.bpSensor = bpSensor;
        this.bpCoordinator = bpCoordinator;
        this.SpO2Sensor = SpO2Sensor;
        this.SpO2Coordinator = SpO2Coordinator;
        this.dataWriter = dataWriter;
        this.patientAccumulator = patientAccumulator;
    }

    public void run() {
        try {
            //System.out.println("Patient " + this.patient.getId() + " in Round " + currentRound);

            // Use components further down the chain to request the data. Make sure the patient is set to read.
            if(patient.getRead()) {
                // The Patient accumulator will be the starting point, waiting for information to trickle into its hash maps.
                this.patientAccumulator.addWriter(this.patient.getId(), this.dataWriter);
                // Assigning coordinators to accumulator's writer
                this.patientAccumulator.getWriter(this.patient.getId()).addBpCoordinator(this.bpCoordinator);
                this.patientAccumulator.getWriter(this.patient.getId()).addSpO2Coordinator(this.SpO2Coordinator);
                // Sending patient from writer to accumulator
                this.patientAccumulator.addPatient(this.patient.getId(), this.patientAccumulator.getWriter(this.patient.getId()).outputPatient(this.patient.getId()));
                //System.out.println(this.dataWriter.patient.getId());
                //this.patientAccumulator.getWriter(this.patient.getId()).outputPatient(this.patient.getId());
                this.patientAccumulator.generateAllScores();
                this.patientAccumulator.generateAlerts();
            }
            // First, output patient measured data to coordinators. Coordinators will create a patient profile with that info and send that to the data writer.
            //this.bpSensor.outputSystolic();
            //this.bpSensor.outputDiastolic();

            // This thread should have everything it needs to calculate the ISS score for this individual patient.
            // Simply pass the information along through each of the components and have the information accumulate in the patient accumulator.
            // What should be output?
            // Accumulated Patient data, including systolic bp, diastolic bp, SpO2, and ISS. Should also show patient alert levels.
            // Also shows current round.
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class SimulatedEnvironment {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        PatientReadings[] patArr = null;
        SphygmomanometerSensor[] bpSensors = null;
        SphygmomanometerCoordinator[] bpCoordinators = null;
        PulseOximeterSensor[] SpO2Sensors = null;
        OxygenCoordinator[] SpO2Coordinators = null;
        PatientDataWriter[] dataWriters = null;
        PatientAccumulator patientAccumulator = null;

        String input = "";

        System.out.println("Welcome to Team 7's Triage Classification System!");
        System.out.println("When prompted, you may select a one of the experiments against which you can test this system.");
        System.out.println("Each experiment will last 20 seconds.");
        System.out.println("When you wish to exit, enter any character.");
        // Consider how much time corresponds to a single round.
        // This will also inform the experiments.

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
                bpSensors = new SphygmomanometerSensor[2];
                bpCoordinators = new SphygmomanometerCoordinator[2];
                SpO2Sensors = new PulseOximeterSensor[2];
                SpO2Coordinators = new OxygenCoordinator[2];
                dataWriters = new PatientDataWriter[2];
                patientAccumulator = new PatientAccumulator();

                initializePatientCollection(patArr, patArr.length);
                initializeRemainingComponents(patArr, bpSensors, bpCoordinators, SpO2Sensors, SpO2Coordinators, dataWriters, patArr.length);
                Thread[] threads = new Thread[patArr.length];
                // For loop that executes for x rounds.
                for(int x = 0; x < 1000; x++) {
                    for(int i = 0; i < patArr.length; i++) {
                        threads[i] = new Thread(new ThreadClass(x + 1, patArr[i], bpSensors[i], bpCoordinators[i], SpO2Sensors[i], SpO2Coordinators[i], dataWriters[i], patientAccumulator));
                        threads[i].start();
                    }
                    for(int i = 0; i < patArr.length; i++) {
                        threads[i].join();
                    }
                    for(int j = 0; j < patArr.length; j++) {
                        Patient p = patientAccumulator.getPatient(j);
                        if(p != null) {
                            System.out.println("Patient " + p.getId() + " in round " + x + "! ");
                            System.out.println("Patient hypertension stage: " + p.getHypertensionStage() + ". Patient SpO2: " + p.getSpO2() + ".");
                        }
                        else {
                            System.out.println("Null in round " + x + "!");
                        }
                    }
                }

                System.out.println(patArr.length);
                System.out.println(bpSensors.length);
                System.out.println(bpCoordinators.length);
                System.out.println(SpO2Sensors.length);
                System.out.println(SpO2Coordinators.length);
                System.out.println(dataWriters.length);
            }
            else if(input.equals("2")) {
                System.out.println("Running Experiment 2");
                patArr = new PatientReadings[4];
                bpSensors = new SphygmomanometerSensor[4];
                bpCoordinators = new SphygmomanometerCoordinator[4];
                SpO2Sensors = new PulseOximeterSensor[4];
                SpO2Coordinators = new OxygenCoordinator[4];
                dataWriters = new PatientDataWriter[4];
                patientAccumulator = new PatientAccumulator();

                initializePatientCollection(patArr, patArr.length);
                initializeRemainingComponents(patArr, bpSensors, bpCoordinators, SpO2Sensors, SpO2Coordinators, dataWriters, patArr.length);
            }
            else if(input.equals("3")) {
                System.out.println("Running Experiment 3");
                patArr = new PatientReadings[6];
                bpSensors = new SphygmomanometerSensor[6];
                bpCoordinators = new SphygmomanometerCoordinator[6];
                SpO2Sensors = new PulseOximeterSensor[6];
                SpO2Coordinators = new OxygenCoordinator[6];
                dataWriters = new PatientDataWriter[6];
                patientAccumulator = new PatientAccumulator();
                initializePatientCollection(patArr, patArr.length);
                initializeRemainingComponents(patArr, bpSensors, bpCoordinators, SpO2Sensors, SpO2Coordinators, dataWriters, patArr.length);
            }
            else if(input.equals("4")) {
                System.out.println("Running Experiment 4");
                patArr = new PatientReadings[2];
                bpSensors = new SphygmomanometerSensor[2];
                bpCoordinators = new SphygmomanometerCoordinator[2];
                SpO2Sensors = new PulseOximeterSensor[2];
                SpO2Coordinators = new OxygenCoordinator[2];
                dataWriters = new PatientDataWriter[2];
                patientAccumulator = new PatientAccumulator();
                initializePatientCollection(patArr, patArr.length);
                initializeRemainingComponents(patArr, bpSensors, bpCoordinators, SpO2Sensors, SpO2Coordinators, dataWriters, patArr.length);
                patArr[1].setRead(false);
            }
            else if(input.equals("5")) {
                System.out.println("Running Experiment 5");
                patArr = new PatientReadings[4];
                bpSensors = new SphygmomanometerSensor[4];
                bpCoordinators = new SphygmomanometerCoordinator[4];
                SpO2Sensors = new PulseOximeterSensor[4];
                SpO2Coordinators = new OxygenCoordinator[4];
                dataWriters = new PatientDataWriter[4];
                patientAccumulator = new PatientAccumulator();
                initializePatientCollection(patArr, patArr.length);
                initializeRemainingComponents(patArr, bpSensors, bpCoordinators, SpO2Sensors, SpO2Coordinators, dataWriters, patArr.length);
                patArr[2].setRead(false);
                patArr[3].setRead(false);
            }
            else if(input.equals("6")) {
                System.out.println("Running Experiment 6");
                patArr = new PatientReadings[6];
                bpSensors = new SphygmomanometerSensor[6];
                bpCoordinators = new SphygmomanometerCoordinator[6];
                SpO2Sensors = new PulseOximeterSensor[6];
                SpO2Coordinators = new OxygenCoordinator[6];
                dataWriters = new PatientDataWriter[6];
                patientAccumulator = new PatientAccumulator();
                initializePatientCollection(patArr, patArr.length);
                initializeRemainingComponents(patArr, bpSensors, bpCoordinators, SpO2Sensors, SpO2Coordinators, dataWriters, patArr.length);
                patArr[3].setRead(false);
                patArr[4].setRead(false);
                patArr[5].setRead(false);
            }
            else {
                break;
            }
            // Resets everything for the next experiment
            patArr = null;
            bpSensors = null;
            bpCoordinators = null;
            SpO2Sensors = null;
            SpO2Coordinators = null;
            dataWriters = null;
            patientAccumulator = null;
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
            System.out.println("Set the measured amount of red light for calculating SpO2 for patient " + patArr[i].getId() + ".");
            patArr[i].setRed(scan.nextInt());
            System.out.println("Set the measured amount of infrared light for calculating SpO2 for patient " + patArr[i].getId() + ".");
            patArr[i].setIR(scan.nextInt());
            scan.nextLine();
        }
    }

    public static void initializeRemainingComponents(PatientReadings[] patArr, SphygmomanometerSensor[] bpSensors, SphygmomanometerCoordinator[] bpCoordinators, PulseOximeterSensor[] SpO2Sensors, OxygenCoordinator[] SpO2Coordinators, PatientDataWriter[] dataWriters, int patientCount) {
        for(int i = 0; i < patientCount; i++) {
            bpSensors[i] = new SphygmomanometerSensor();
            bpSensors[i].patientReadings = patArr[i];
            bpCoordinators[i] = new SphygmomanometerCoordinator();
            bpSensors[i].sphygmomanometerCoordinator = bpCoordinators[i];
            bpCoordinators[i].sphygmomanometerSensor = bpSensors[i];

            SpO2Sensors[i] = new PulseOximeterSensor();
            SpO2Sensors[i].patientReadings = patArr[i];
            SpO2Coordinators[i] = new OxygenCoordinator();
            SpO2Sensors[i].oxygenCoordinator = SpO2Coordinators[i];
            SpO2Coordinators[i].pulseOximeterSensor = SpO2Sensors[i];

            dataWriters[i] = new PatientDataWriter();
            dataWriters[i].addBpCoordinator(bpCoordinators[i]);
            dataWriters[i].addSpO2Coordinator(SpO2Coordinators[i]);
        }
    }
}
