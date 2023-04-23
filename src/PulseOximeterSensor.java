public class PulseOximeterSensor {

	private float red = 0;

	private float ir = 1;

	public PatientReadings patientReadings;

	public OxygenCoordinator oxygenCoordinator;

	public float getRed() {
		return this.red;
	}

	public void setRed(float red) {
		this.red = red;
	}

	public float getIR() {
		return this.ir;
	}

	public void setIR(float ir) {
		this.ir = ir;
	}

	public float outputRatio() {
		this.setRed(patientReadings.getRed());
		this.setIR(patientReadings.getIR());
		return this.getRed()/this.getIR();
	}

}
