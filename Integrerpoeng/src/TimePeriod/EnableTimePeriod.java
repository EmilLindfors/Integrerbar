package TimePeriod;

import Organisations.EnableOrganisations;

public class EnableTimePeriod {
	
	private static boolean periodEnabled;

	// Thread-safe due to guarantees about initializers
	private static final EnableTimePeriod instance = new EnableTimePeriod();

	private EnableTimePeriod() {
	}

	public static EnableTimePeriod getInstance() {
		periodEnabled = true;
		return instance;
	}
	
	public static boolean checkIfEnabled(){
		return periodEnabled;
	}

}
