package hubs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class small {

	String writePath;
	String readPath;

	public small(String writePath, String readPath) {
		this.readPath = readPath;
		this.writePath = writePath;
	}

	void doWork() {
		File writeFile = new File(writePath);
		File readFile = new File(readPath);

		FileWriter writer = null;
		try {
			writer = new FileWriter(writeFile, false);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileReader reader = null;
		try {
			reader = new FileReader(readFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader buffReader = new BufferedReader(reader);
		String line;
		try {
			while ((line = buffReader.readLine()) != null) {
				// use comma as separator
				String[] columns = line.split(",");
				String[] split;
				String sub = "ThereIsNotWayItEqualsThis";
				if (columns.length == 2) {
					if (columns[0].contains("/")) {
						split = columns[0].split("/");
						sub = split[0];
						columns[0] = split[1];
					}
					if (columns[1].contains("/")) {
						split = columns[1].split("/");
						if(split[0].equals(sub)){
							columns[1] = split[1];
						}
						else{
						columns[1] = split[0];
						}
					}
					
					if (!(columns[1].equals(columns[0]))) {
						writer.write(columns[0] + "," + columns[1] + "\n");
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

