public class Patient {

	private float hypertensionStage = -1;

	private float SpO2 = -1;

	private int ISS = -1;

	private int id = -1;

	private PatientDataWriter patientDataWriter;

	private PatientAccumulator patientAccumulator;

	private SphygmomanometerCoordinator sphygmomanometerCoordinator;

	private OxygenCoordinator oxygenCoordinator;

	public float getHypertensionStage() {
		return this.hypertensionStage;
	}

	public void setHypertensionStage(float hypertensionStage) {
		this.hypertensionStage = hypertensionStage;
	}

	public float getSpO2() {
		return this.SpO2;
	}

	public void setSpO2(float SpO2) {
		this.SpO2 = SpO2;
	}

	public int getISS() {
		return this.ISS;
	}

	public void setISS(int ISS) {
		this.ISS = ISS;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
