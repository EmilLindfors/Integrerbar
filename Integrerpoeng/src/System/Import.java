package System;

import java.util.ArrayList;

public interface Import {
	/**
	 * Interface for imports of csv files
	 * @param path absolute path to the file
	 * @return
	 */
	abstract ArrayList<String> ImportFile(String path);

}
