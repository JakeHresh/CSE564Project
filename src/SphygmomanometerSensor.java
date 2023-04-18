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
		return 0;
	}

	public float outputDiastolic() {
		return 0;
	}

}
