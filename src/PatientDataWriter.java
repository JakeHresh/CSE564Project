public class PatientDataWriter {

	private Patient patient;

	private SphygmomanometerCoordinator sphygmomanometerCoordinator;

	private OxygenCoordinator oxygenCoordinator;

	private PatientAccumulator patientAccumulator;

	public void addSpO2Coordinator(OxygenCoordinator coord) {
		this.oxygenCoordinator = coord;
	}

	public void addBpCoordinator(SphygmomanometerCoordinator coord) {
		this.sphygmomanometerCoordinator = coord;
	}

	// Outputting the patient creates and assigns a new patient, and creates and assigns a patient accumulator.
	// The latter assignment simultaneously provides itself as a reference for the patient accumulator.
	public Patient outputPatient() {
		return null;
	}

}
