import java.util.HashMap;
public class PatientAccumulator {

	private HashMap<Integer, Patient> patientCollection = new HashMap<Integer, Patient>();

	private HashMap<Integer, PatientDataWriter> patientDataWriterCollection = new HashMap<Integer, PatientDataWriter>();

	private AlertGenerator alertGenerator;

	private ISSCalculator iSSCalculator;

	public boolean addPatient(int key, Patient patient) {
		this.patientCollection.put(Integer.valueOf(key), patient);
		return false;
	}

	public Patient getPatient(int key) {
		return this.patientCollection.get(Integer.valueOf(key));
	}

	public boolean addWriter(int key, PatientDataWriter writer) {
		this.patientDataWriterCollection.put(Integer.valueOf(key), writer);
		return true;
	}

	public PatientDataWriter getWriter(int key) {
		return this.patientDataWriterCollection.get(Integer.valueOf(key));
	}

	public HashMap<Integer, Patient> getPatientCollection() {
		return this.patientCollection;
	}

	public void generateAllScores() {
		if(this.iSSCalculator == null) {
			this.iSSCalculator = new ISSCalculator();
		}
		// Useful for hashmap iteration
		// https://www.programiz.com/java-programming/library/hashmap/foreach
		this.patientCollection.forEach((key, value) -> {
			this.iSSCalculator.calculateHTISS(value.getHypertensionStage());
			this.iSSCalculator.calculateSpO2AIS(value.getSpO2());
			int tempISS = this.iSSCalculator.outputISS();
			value.setISS(tempISS);
		});
	}

	public void generateAlerts() {
		System.out.println("Generating alerts...");
		if(this.alertGenerator == null) {
			this.alertGenerator = new AlertGenerator();
		}
		this.patientCollection.forEach((key, value) -> {
			this.alertGenerator.generateAlert(value);
			// check here whether to administer medicine
			if(this.alertGenerator.administerMedicine(value)) {
				this.patientDataWriterCollection.get(key).sphygmomanometerCoordinator.sphygmomanometerSensor.patientReadings.setSystolic(this.patientDataWriterCollection.get(key).sphygmomanometerCoordinator.sphygmomanometerSensor.patientReadings.getSystolic() - 0.1f);
				this.patientDataWriterCollection.get(key).sphygmomanometerCoordinator.sphygmomanometerSensor.patientReadings.setDiastolic(this.patientDataWriterCollection.get(key).sphygmomanometerCoordinator.sphygmomanometerSensor.patientReadings.getDiastolic() - 0.1f);
				this.patientDataWriterCollection.get(key).sphygmomanometerCoordinator.setReread(true);
			}
			if(this.alertGenerator.pumpOxygen(value)) {
				this.patientDataWriterCollection.get(key).oxygenCoordinator.pulseOximeterSensor.patientReadings.setRed(this.patientDataWriterCollection.get(key).oxygenCoordinator.pulseOximeterSensor.patientReadings.getRed()/1.005f);
				this.patientDataWriterCollection.get(key).oxygenCoordinator.setReread(true);
			}
		});
	}

}
