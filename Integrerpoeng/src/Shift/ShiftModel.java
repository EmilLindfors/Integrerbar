package Shift;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Shift {

	private String name;
	private String supervisor;
	private LocalDate date;
	private LocalTime open;
	private LocalTime closed;
	private ArrayList<String> workers;

	public Shift(String name, String date, String openClosed, String supervisor) {
		super();
		this.name = name;
		this.supervisor = supervisor;
		String[] dat = date.split(".");
		this.date = LocalDate.of(Integer.parseInt(dat[2]), Integer.parseInt(dat[1]), Integer.parseInt(dat[0]));

		String[] str = openClosed.split("-");
		String[] t = new String[4];
		for (String s : str) {
			t = s.split(":");
		}

		this.open = LocalTime.of(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
		this.closed = LocalTime.of(Integer.parseInt(t[2]), Integer.parseInt(t[3]));
		this.workers = new ArrayList<String>();
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getSupervisor() {
		return supervisor;
	}

	protected void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	protected LocalDate getDate() {
		return date;
	}

	protected void setDate(LocalDate date) {
		this.date = date;
	}

	protected LocalTime getOpen() {
		return open;
	}

	protected void setOpen(LocalTime open) {
		this.open = open;
	}

	protected LocalTime getClosed() {
		return closed;
	}

	protected void setClosed(LocalTime closed) {
		this.closed = closed;
	}

	//*************** Manage shift workers *********************
	
	//gets all workers
	protected ArrayList<String> getWorkers() {
		return workers;
	}

	//adds a worker
	protected boolean addWorker(String name, String time) {
		for (String s : workers) {
			String[] worker = s.split(",");
			String workerName = worker[0].toString();
			if (!workerName.equalsIgnoreCase(name)) {
				workers.add(name + "," + time);
				return true;
			}
		}
		return false;
	}
	
	//get a worker by name
	protected String getWorkerByName(String name) {
		for (String s : workers) {
			String[] worker = s.split(",");
			String workerName = worker[0].toString();
			if (workerName.equalsIgnoreCase(name)) {
				return s;
			}
		}
		System.out.println("Did not find a worker by that name");
		return "";
	}
	
	//updates a worker by finding the name and updating if exist
	protected boolean UpdateWorker(String name, String time){
		for (String s : workers) {
			String[] worker = s.split(",");
			String workerName = worker[0].toString();
			if (workerName.equalsIgnoreCase(name)) {
				s = name + "," + time;
				return true;
			}
		}
		return false;
		
	}
	
	//deletes a worker of a shift by name
	protected boolean deleteWorkerByName(String name){
		for (String s : workers) {
			String[] worker = s.split(",");
			String workerName = worker[0].toString();
			if (workerName.equalsIgnoreCase(name)) {
				workers.remove(s);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + "," + date + "," + open + "," + closed);
		for (String s : workers) {
			sb.append("," + s);
		}
		return sb.toString();
	}

}
