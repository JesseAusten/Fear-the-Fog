package CoreGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Class to read and write JSON files for persistent storage
 */

public class PatternIO {

	JSONObject patternFile;
	String fileName;

	public PatternIO() {

		fileName = "patterns.json";
		File file = new File(fileName);

		JSONParser parse = new JSONParser();

		if (file.exists()) { // if the file exists, parses existing json as an array of json objects

			try {

				patternFile = (JSONObject) parse.parse(new FileReader(fileName));

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			} catch (ParseException e) {

				e.printStackTrace();
			}

		} else { // if the file does not exist, creates json file and writes an empty JSON object
					// to it

			patternFile = new JSONObject();

			try {

				file.createNewFile();
				FileWriter writeFile = new FileWriter(file);
				writeFile.write(patternFile.toString());
				writeFile.flush();
				writeFile.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	/*
	 * Accept 2 integer arrays corresponding to a tile pattern, as well as a name
	 * Then adds to JSON array to be written to the file
	 */

	public void savePattern(int[] cols, int[] rows, String patternName) {

		JSONObject savePattern = new JSONObject();
		JSONArray patternCol = new JSONArray();
		JSONArray patternRow = new JSONArray();

		for (int i : cols) {

			patternCol.add(i);
		}

		for (int x : rows) {

			patternRow.add(x);

		}

		savePattern.put("column", patternCol);
		savePattern.put("row", patternRow);
		patternFile.put(patternName, savePattern);

	}

	/*
	 * Load pattern from file as a 2d array of integers
	 */

	public int[][] loadPattern(String patternName) {

		JSONObject pattern = (JSONObject) patternFile.get(patternName);
		JSONArray col = (JSONArray) pattern.get("column");
		JSONArray row = (JSONArray) pattern.get("row");

		int[][] returnValues = new int[2][col.size()];
		int index = 0;

		for (Object i : col) {
			
			int columnValue = Integer.parseInt(i.toString());
			returnValues[0][index++] = columnValue;
		}

		index = 0;

		for (Object i : row) {
			
			int rowValue = Integer.parseInt(i.toString());
			returnValues[1][index++] = rowValue;

		}

		return returnValues;

	}

	/*
	 * Writes JSON Array to file, overwrites existing data if it exists
	 */

	public void writeToFile() {

		try {

			FileWriter writeFile = new FileWriter(fileName);
			writeFile.write(patternFile.toString());
			writeFile.flush();
			writeFile.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) { // for testing

		int[] testCol = { 1, 2, 3, 4, 5, 6, 7 };
		int[] testRow = { 7, 3, 2, 1, 4, 5, 5 }; // testing only
		String name = "Player";
		
		
		PatternIO test = new PatternIO();
		test.savePattern(testCol, testRow, name);
		test.writeToFile();

		int[][] temp = test.loadPattern("Player");

		for (int i = 0; i < temp.length; i++) { // MOOR TESTING
			for (int j = 0; j < temp[i].length; j++) {
				System.out.println(temp[i][j]);
				

			}

		}

	}

}
