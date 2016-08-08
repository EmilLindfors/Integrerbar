package Shift;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import com.opencsv.CSVReader;

import System.Import;

//NEEDS TO BE REMODELED
public class ImportShift implements Import {

	@Override
	public ArrayList<String> ImportFile(String file) {

		ArrayList<String> imported = new ArrayList<String>();

		try {

			CSVReader reader = new CSVReader(new FileReader(file));
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {

				for (String s : nextLine) {
					if(!s.equals("")){
					imported.add(s+",");
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imported;
	}

	public void turnListToShiftObjects(ArrayList<String> list) {
		ArrayList<Shift> shifts = new ArrayList<Shift>();
		for (String s : list) {
			String[] shft = s.split(",");
			System.out.println(s);
			for (int i = 0; i < shft.length - 1; i++) {
				System.out.println(shft[0]);
				shifts.add(new Shift(shft[0], shft[1], shft[2], shft[3]));
			}

		}
	}
}
