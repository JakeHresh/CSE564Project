public class PatientDataWriter {

	public Patient patient;

	public SphygmomanometerCoordinator sphygmomanometerCoordinator;

	public OxygenCoordinator oxygenCoordinator;

	public PatientAccumulator patientAccumulator;

	public void addSpO2Coordinator(OxygenCoordinator coord) {
		this.oxygenCoordinator = coord;
	}

	public void addBpCoordinator(SphygmomanometerCoordinator coord) {
		this.sphygmomanometerCoordinator = coord;
	}

	// Outputting the patient creates and assigns a new patient, and creates and assigns a patient accumulator.
	// The latter assignment simultaneously provides itself as a reference for the patient accumulator.
	public Patient outputPatient(int id) {
		this.patient = new Patient();
		this.patient.setId(id);
		this.patient.setHypertensionStage(this.sphygmomanometerCoordinator.outputHypertensionStage());
		this.patient.setSpO2(this.oxygenCoordinator.outputOxygenSaturation());
		return this.patient;
	}

}
