public class PatientReadings {

	private int id = -1;

	private float measured_systolic = -1;

	private float measured_diastolic = -1;

	private float measured_red = -1;

	private float measured_ir = -1;

	private boolean read = true;

	private SphygmomanometerSensor sphygmomanometerSensor;

	private PulseOximeterSensor pulseOximeterSensor;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSystolic() {
		return this.measured_systolic;
	}

	public void setSystolic(float systolic) {
		this.measured_systolic = systolic;
	}

	public float getDiastolic() {
		return this.measured_diastolic;
	}

	public void setDiastolic(float diastolic) {
		this.measured_diastolic = diastolic;
	}

	public float getRed() {
		return this.measured_red;
	}

	public void setRed(float red) {
		this.measured_red = red;
	}

	public float getIR() {
		return this.measured_ir;
	}

	public void setIR(float ir) {
		this.measured_ir = ir;
	}

	public boolean getRead() {
		return this.read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

}
