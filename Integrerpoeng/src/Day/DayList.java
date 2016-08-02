package Day;

import java.time.LocalDate;
import java.util.ArrayList;

public class DayList {
	
	private ArrayList<Day> listOfDays;
	
	public DayList(){
		this.listOfDays = new ArrayList<Day>();
	}
	public void addDay(Day day){
		listOfDays.add(day);
	}
	public Day GetDay(LocalDate date){
		
		for(Day d: listOfDays){
			if(d.getDate().equals(date)){
				return d;
			} 
		}
		return new NullDay();
		
	}
	
	public ArrayList<Day> getDayList(){
		return listOfDays;
	}
}
