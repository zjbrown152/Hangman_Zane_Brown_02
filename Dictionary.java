//


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Dictionary {
	List<String> wordList = new ArrayList<String>();
	private SecureRandom random = new SecureRandom();
	
	public Dictionary()   {
		
		List<String> wordList = new ArrayList<String>();
		File file = new File("C:\\Users\\15024\\Documents\\General Chem\\Power Points\\Zane Brown html\\wordsheet.txt");
		Scanner scan;
		try {
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				wordList.add(scan.nextLine());
			}
			scan.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		
	}
	
	public void readFile() throws FileNotFoundException {
		List<String> wordList = new ArrayList<String>();
		File file = new File("wordsheet.txt");
		Scanner scan;
		
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				wordList.add(scan.nextLine());
			}
			scan.close();
			return;
	
		}
		
	
	
	
	public String chooseWord() {
		String[] wordsheet = wordList.toArray(new String[200]);
		int index = random.nextInt(wordsheet.length);
		return wordsheet[index];
	}
}
