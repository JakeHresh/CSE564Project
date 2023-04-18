public class SphygmomanometerSensor {

	public PatientReadings patientReadings;

	public SphygmomanometerCoordinator sphygmomanometerCoordinator;

	public SphygmomanometerSensor() {
		this.patientReadings = null;
		this.sphygmomanometerCoordinator = null;
	}
	public SphygmomanometerSensor(PatientReadings patientReadings, SphygmomanometerCoordinator sphygmomanometerCoordinator) {
		this.patientReadings = patientReadings;
		this.sphygmomanometerCoordinator = sphygmomanometerCoordinator;
	}

	public float outputSystolic() {
		if(this.sphygmomanometerCoordinator == null) {
			this.sphygmomanometerCoordinator = new SphygmomanometerCoordinator();
			this.sphygmomanometerCoordinator.sphygmomanometerSensor = this;
		}
		return patientReadings.getSystolic();
	}

	public float outputDiastolic() {
		return 0;
	}

}
