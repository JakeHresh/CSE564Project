public class ISSCalculator {

	private int ht_ISS;

	private int SpO2_AIS;

	private PatientAccumulator patientAccumulator;

	public int getHt_ISS() {
		return this.ht_ISS;
	}

	public void setHt_ISS(int ht_ISS) {
		this.ht_ISS = ht_ISS;
	}

	public int getSpO2_AIS() {
		return this.SpO2_AIS;
	}

	public void setSpO2_AIS(int SpO2_AIS) {
		this.SpO2_AIS = SpO2_AIS;
	}

	public void calculateHTISS(float hypertensionStage) {
		this.setHt_ISS((int)((hypertensionStage + 1) * (hypertensionStage + 1)) - 1);
	}

	public void calculateSpO2AIS(float SpO2) {
		int AIS = 0;
		if(SpO2 < 80 && SpO2 != 0) {
			AIS = 4;
		}
		else if(SpO2 < 85) {
			AIS = 3;
		}
		else if(SpO2 < 90) {
			AIS = 2;
		}
		else if(SpO2 < 95) {
			AIS = 1;
		}
		else if(SpO2 >= 95 || SpO2 == 0) {
			AIS = 0;
		}
		this.setSpO2_AIS(AIS);
	}

	public int outputISS() {
		return this.getHt_ISS() + (this.getSpO2_AIS() * this.getSpO2_AIS());
	}

}
