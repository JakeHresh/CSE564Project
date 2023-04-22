public class OxygenCoordinator {

	private boolean re_read = true;

	public PulseOximeterSensor pulseOximeterSensor;

	public PatientDataWriter patientDataWriter;

	public Patient patient;

	public float outputOxygenSaturation() {
		float SpO2 = -1;
		if(this.re_read) {
			float r = this.pulseOximeterSensor.outputRatio();
			if(r != 0) {
				if(r < 600) {
					SpO2 = 100;
				}
				else if(r < 800) {
					SpO2 = 95;
				}
				else if(r < 1000) {
					SpO2 = 85;
				}
				else if(r < 1200) {
					SpO2 = 80;
				}
				else if(r < 1400) {
					SpO2 = 70;
				}
				else if(r < 1600) {
					SpO2 = 65;
				}
				else if(r < 1800) {
					SpO2 = 60;
				}
				else if(r < 2000) {
					SpO2 = 50;
				}
				else if(r < 2200) {
					SpO2 = 45;
				}
				else if(r < 2400) {
					SpO2 = 35;
				}
				else if(r < 2600) {
					SpO2 = 30;
				}
				else if(r < 2800) {
					SpO2 = 25;
				}
				else if(r < 3000) {
					SpO2 = 15;
				}
				else if(r < 3200) {
					SpO2 = 10;
				}
				else {
					SpO2 = 0;
				}
			}
			this.re_read = false;
		}
		return SpO2;
	}

	public boolean getReread() {
		return this.re_read;
	}

	public void setReread(boolean re_read) {
		this.re_read = re_read;
	}

}
