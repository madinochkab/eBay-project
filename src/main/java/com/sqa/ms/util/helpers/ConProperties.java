/**
 *   File Name: ConProperties.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 27, 2016
 *
 */

package com.sqa.ms.util.helpers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/**
 * ConProperties //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Siebenthal, Madina
 * @version 1.0.0
 * @since 1.0
 *
 */
public class ConProperties {
	public static HashMap<String, String> conProperties(Properties props) {
		// Create HashMap<String, String>
		HashMap<String, String> hmProps = new HashMap<String, String>();
		// Use a loop to put in Property values inside the HashMap
		for (Object key : props.keySet()) {
			// Add the element from the Properties file to the HashMap
			hmProps.put((String) key, props.getProperty((String) key));
		}

		// Return created HashMap
		return hmProps;
	}

	public static HashMap<String, String> conProperties(String propertiesFileLocation) {
		// convert text file into an ArrayList with each String element
		// representing a separate line
		ArrayList<String> dataLines = evalTextDataLines(propertiesFileLocation);
		// display the content which is stored in an ArrayList<String> type
		// variable
		// ConProperties.displayDataLines(dataLines);
		// converting Arraylist<String> into HashMap collection of key / value
		HashMap<String, String> dataHashMap = ConProperties.convertLineContents(dataLines);
		// display the content of a HashMap<String, String> to console
		ConProperties.displayDataContents(dataHashMap);

		return dataHashMap;
	}

	public static HashMap<String, String> convertLineContents(ArrayList<String> textFileLineContents) {
		// create HashMap of string key and string values and initialize it
		HashMap<String, String> dataHashMap = new HashMap<>();
		// use loop to iterate through all strings in the collection of strings
		// to retrieve the key and associated values
		for (int i = 0; i < textFileLineContents.size(); i++) {
			// convert the line for each element inside the collection of String
			// into an array with two elements representing the key and value
			String[] lineElements = textFileLineContents.get(i).split("=");
			// set the first element to the key variable and trim to remove
			// white space
			String key = lineElements[0].trim();
			//// set the second element to the value variable nd trim to remove
			//// white space
			String value = lineElements[1].trim();
			// add keys and values to the HashMap
			dataHashMap.put(key, value);

		}
		return dataHashMap;
	}

	public static void displayDataContents(HashMap<String, String> properties) {
		System.out.println("HM Props properties: \n ");
		// use Set named keys to hold HashMap properties key values
		Set<String> keys = properties.keySet();
		// use
		for (String key : keys) {
			// System.out.print("Property: " + key);
			// System.out.println("- Value : [" + properties.get(key) + "]");
			System.out.print("Property:[" + key);
			// Display value associated with key
			System.out.println("] - Value:[" + properties.get(key) + "]");
		}

	}

	public static void displayDataLines(ArrayList<String> textFileLineContents) {

		// TODO display contents of passed parameter to console
		for (int i = 0; i < textFileLineContents.size(); i++) {
			System.out.println(textFileLineContents.get(i));
		}

	}

	// method to sidplay properties
	public static void displayProperties(Properties props) {
		HashMap<String, String> hmProps = conProperties(props);
		ConProperties.displayDataContents(hmProps);

	}

	public static ArrayList<String> evalTextDataLines(String textFileLoadLocation) {
		// TODO create arraylist to initialize it
		ArrayList<String> dataLine = new ArrayList<String>();

		// This will reference one line at a time
		String line;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(textFileLoadLocation);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				// TODO add line to arraylist collectioin
				dataLine.add(line);

			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + textFileLoadLocation + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + textFileLoadLocation + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		// TODO return arraylist collection
		return dataLine;
	}

	// method to load porperties
	public static Properties loadProperties(String fileLocation) {
		// create properties boject
		Properties props = new Properties();
		try {
			InputStream is = new FileInputStream(fileLocation);
			// load the properties based on file location
			props.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;

	}

	public static void main(String[] args) {

		Properties props = ConProperties.loadProperties("src/main/resources/data01.properties");
		ConProperties.displayProperties(props);
		// System.out.println(props);

	}

}
