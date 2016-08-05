package Shift;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import System.Import;

public class ImportShift implements Import {

	@Override
	public ArrayList<String> ImportFile(String path) {

		ArrayList<String> imported = new ArrayList<String>();

		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
			String line;
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] shft = line.split(",");

				for (String s : shft) {
					if (!s.equals("")) {

						imported.add(s + ",");
					}
				}

			}
			br.close();

		} catch (IOException e) {
			System.out.println("Failed to read users file.");
		}
		return imported;
	}

	public ArrayList<Shift> turnListToShiftObjects(ArrayList<String> list) {
		ArrayList<Shift> shifts = new ArrayList<Shift>();
		for (String s : list) {
			String[] shft = s.split(",");

			for (int i = 0; i < shft.length-1; i++) {
				shifts.add(new Shift(shft[0], shft[1], shft[2], shft[3]));
			}

		}
		return null;
	}
}
