public class AlertGenerator {

	private int alert_level;

	private PatientAccumulator patientAccumulator;

	public int getAlertLevel() {
		return this.alert_level;
	}

	public void setAlertLevel(int alert_level) {
		this.alert_level = alert_level;
	}

	public void generateAlert(Patient patient) {
		int iss = patient.getISS();
		if(iss == -1) {
			this.setAlertLevel(-1);
			System.out.println("Patient " + patient.getId() + " Alert Level: Not Read");
		}
		else if(iss == 0) {
			this.setAlertLevel(0);
			System.out.println("Patient " + patient.getId() + " Alert Level: No Response");
		}
		else if(iss > 0 && iss < 7) {
			this.setAlertLevel(1);
			System.out.println("Patient " + patient.getId() + " Alert Level: Delayed");
		}
		else if(iss > 6 && iss < 17) {
			this.setAlertLevel(2);
			System.out.println("Patient " + patient.getId() + " Alert Level: Urgent");
		}
		else if(iss > 16) {
			this.setAlertLevel(3);
			System.out.println("Patient " + patient.getId() + " Alert Level: Immediate");
		}
	}

	public boolean administerMedicine(Patient patient) {
		boolean administerMedicine = false;
		if(patient.getHypertensionStage() >= 2) {
			administerMedicine = true;
		}
		return administerMedicine;
	}

	public boolean pumpOxygen(Patient patient) {
		boolean pumpOxygen = false;
		if(patient.getSpO2() < 95) {
			pumpOxygen = true;
		}
		return pumpOxygen;
	}

}
