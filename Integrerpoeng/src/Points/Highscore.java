package Points;

import java.util.ArrayList;
import java.util.Collections;

import User.RealUser;

public class Highscore {
	
	public void showHighscore(ArrayList<RealUser> list){
		Collections.sort(list);
		System.out.println("****** Highscores ********");
		for(RealUser u: list){
			System.out.printf("%-30s %d\n",u.getName(),u.getPoints().getTotalPoints());
		}
		System.out.println("**************************\n");
	}
}
