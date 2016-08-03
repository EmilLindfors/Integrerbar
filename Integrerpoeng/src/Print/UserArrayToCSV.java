package Print;

import java.util.ArrayList;
import java.util.Comparator;
import User.RealUser;

public class UserArrayToCSV implements ArrayToCSV {

	
	
	
	@Override
	public ArrayList<String> formatToStringList(ArrayList<? extends Object> list, String[] valueList) {

		ArrayList<String> formattedList = new ArrayList<String>();

		// perform a check to see if the array is a RealUserArray
		if (!list.get(0).getClass().equals(RealUser.class)) {
			System.out.println("Error: List is not a UserList");
			return formattedList;
		}

		@SuppressWarnings("unchecked")
		ArrayList<RealUser> userList = (ArrayList<RealUser>) list;
		
		//sort by name
		userList.sort(Comparator.comparing(RealUser::getName));

		for (RealUser u : userList) {
			String temp = "";

			for (String values : valueList){


				switch (values) {
				case "name":
					temp += (u.getName());
					break;
				case "total earned points":
					temp += ("," + (u.getPoints().getTotalPoints()));
					break;
				case "total used points":
					temp += ("," + u.getPoints().getUsedPoints());
					break;
				case "role":
					temp += ("," + u.getRole());
					break;

				}
			}
			formattedList.add(temp);
		}

		return formattedList;
	}

}
