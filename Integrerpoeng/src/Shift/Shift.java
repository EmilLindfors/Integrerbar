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
		this.date = LocalDate.of(Integer.parseInt(dat[2]),Integer.parseInt(dat[1]),Integer.parseInt(dat[0]));
		
		String[] str = openClosed.split("-");
		String[] t = new String[4];
		for(String s:str){
			t = s.split(":");
		}
		
		this.open = LocalTime.of(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
		this.closed = LocalTime.of(Integer.parseInt(t[2]), Integer.parseInt(t[3]));
		this.workers = new ArrayList<String>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getOpen() {
		return open;
	}
	public void setOpen(LocalTime open) {
		this.open = open;
	}
	public LocalTime getClosed() {
		return closed;
	}
	public void setClosed(LocalTime closed) {
		this.closed = closed;
	}
	public ArrayList<String> getWorkers() {
		return workers;
	}
	public void setWorkers(ArrayList<String> workers) {
		this.workers = workers;
	}
	public void addWorkers(String name, String time){
		workers.add(name+","+time);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name+","+date+","+open+","+closed);
		for(String s: workers){
			sb.append(","+s);
		}
		return sb.toString();
	}
	
	

}
