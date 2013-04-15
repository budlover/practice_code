import java.io.*;
import java.util.*;

public class readFile {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("haha.txt"));
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] wordsFromText = line.split("\\s");

				for(String word:wordsFromText) {
					//if (word.matches("[A-Za-z]+"))
					list.add(word.toLowerCase());
				}
			}
		} catch(FileNotFoundException e) {
			System.err.println("Cannot find the file");
		} finally {
			if(scanner!= null) scanner.close();
		}


		for (String str : list)
			System.out.println(str);

	}


}
