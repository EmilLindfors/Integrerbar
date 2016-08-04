package InputValidation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {
	
	public static boolean validateDate(String date){
		
		String datePattern = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
		Pattern pattern = Pattern.compile(datePattern);
		Matcher matcher = pattern.matcher(date);
		
		if (matcher.matches()){
			return true;
		} else {
			return false;
		}
	}

}
