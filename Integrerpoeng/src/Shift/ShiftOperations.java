package Shift;

import java.util.ArrayList;

/**
 * An interface class that should contain all Shift API
 * 
 * @author Emil
 *
 */
public interface ShiftOperations {
	
	//***************** Shift Operations ******************
	
	abstract Shift createShift();
	abstract Shift getShift();
	abstract boolean updateShift();
	abstract boolean deleteShift();
	
	
	
	
	//***************** Shift worker Operations *************
	
	abstract ArrayList<String> getWorkers(String name);
	
	/**
	 * Add a worker to the shift
	 * @param name String full name of the worker of the shift
	 * @param time the time represented as HH:MM - HH:MM
	 * @return true if user was not already in this shift, false otherwise
	 */
	abstract boolean addWorker(String name, String time);
	
	/**
	 * Get a worker from the shift by full name if exist
	 * @param name String full name of the worker of the shift
	 * @return String in the format name+","+time;
	 */
	abstract String getWorkerByName(String name);
	
	/**
	 * Updates a worker of the shift
	 * @param name String full name of the worker of the shift
	 * @param time time the time represented as HH:MM - HH:MM
	 * @return true if worker name was found and information updated, false otherwise
	 */
	abstract boolean UpdateWorkers(String name, String time);
	
	/**
	 * Deletes a worker of the shift
	 * @param name String full name of the worker of the shift
	 * @return true if worker name was found and information deleted, false otherwise
	 */
	abstract boolean deleteWorkerByName(String name);
	

}
