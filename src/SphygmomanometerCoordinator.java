public class SphygmomanometerCoordinator {

	private boolean re_read;

	public SphygmomanometerSensor sphygmomanometerSensor;

	public PatientDataWriter patientDataWriter;

	public Patient patient;

	public float outputHypertensionStage() {
		float systolic = this.sphygmomanometerSensor.outputSystolic();
		float diastolic = this.sphygmomanometerSensor.outputDiastolic();
		float hts = 0;
		if(systolic != 0 && diastolic != 0) {
			if(systolic >= 180 || diastolic >= 120) {
				hts = 3;
			}
			else if(systolic >= 140 || diastolic >= 90) {
				hts = 2;
			}
			else if(systolic >= 130 || diastolic >= 80) {
				hts = 1;
			}
			else {
				hts = 0;
			}
		}
		return hts;
	}

	public boolean getReread() {
		return false;
	}

	public void setReread(boolean re_read) {

	}

}
