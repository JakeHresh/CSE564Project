import java.util.HashMap;
public class PatientAccumulator {

	private HashMap<Integer, Patient> patientCollection;

	private HashMap<Integer, PatientDataWriter> patientDataWriterCollection;

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

	public void generateAllScores() {

	}

	public void generateAlerts() {

	}

}
