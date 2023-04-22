public class SphygmomanometerCoordinator {

	private boolean re_read = true;

	public SphygmomanometerSensor sphygmomanometerSensor;

	public PatientDataWriter patientDataWriter;

	public Patient patient;

	public float outputHypertensionStage() {
		float hts = -1;
		if(this.re_read) {
			float systolic = this.sphygmomanometerSensor.outputSystolic();
			float diastolic = this.sphygmomanometerSensor.outputDiastolic();
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
			this.re_read = false;
		}
		return hts;
	}

	public boolean getReread() {
		return this.re_read;
	}

	public void setReread(boolean re_read) {
		this.re_read = re_read;
	}

}
