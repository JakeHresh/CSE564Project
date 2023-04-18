public class AlertGenerator {

	private int alert_level;

	private PatientAccumulator patientAccumulator;

	public int getAlertLevel() {
		return 0;
	}

	public void setAlertLevel(int alert_level) {

	}

	public void generateAlert(Patient patient) {
		int iss = patient.getISS();
		if(iss == 0) {
			System.out.println("Patient " + patient.getId() + " Alert Level: No Response");
		}
		else if(iss > 0 && iss < 7) {
			System.out.println("Patient " + patient.getId() + " Alert Level: Delayed");
		}
		else if(iss > 6 && iss < 17) {
			System.out.println("Patient " + patient.getId() + " Alert Level: Urgent");
		}
		else if(iss > 16) {
			System.out.println("Patient " + patient.getId() + " Alert Level: Immediate");
		}
	}

	public boolean administerMedicine(Patient patient) {
		return false;
	}

	public boolean pumpOxygen(Patient patient) {
		return false;
	}

}
