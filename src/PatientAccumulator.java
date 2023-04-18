import java.util.HashMap;
public class PatientAccumulator {

	private HashMap<Integer, Patient> patientCollection;

	private HashMap<Integer, PatientDataWriter> patientDataWriterCollection;

	private AlertGenerator alertGenerator;

	private ISSCalculator iSSCalculator;

	public boolean addPatient(int key, Patient patient) {
		patientCollection.put(Integer.valueOf(key), patient);
		return false;
	}

	public boolean addWriter(int key, PatientDataWriter writer) {
		patientDataWriterCollection.put(Integer.valueOf(key), writer);
		return true;
	}

	public void generateAllScores() {

	}

	public void generateAlerts() {

	}

}
