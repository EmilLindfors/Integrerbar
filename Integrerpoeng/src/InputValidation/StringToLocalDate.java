package InputValidation;

import java.time.LocalDate;

public class StringToLocalDate {
	
	public static LocalDate createNewLocalDate(String date){
		if(ValidateInput.validateDate(date)){
			String[] parts = date.split("-");
			return LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

		}
		return null;
	}

}
