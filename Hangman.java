import java.io.*;
import java.util.Scanner;

public class Hangman 
{
	 int wins;
	 int losses;
	 String currentWord=new String("");
	 Dictionary dictionary=new Dictionary();
	
	Scanner input= new Scanner(System.in);
	
	public Hangman() 
	{
		this.wins=0;
		this.losses=0;
		
	}
	
	public void loadWL() throws FileNotFoundException
	{
		File tally=new File("kd.txt");
		Scanner aScanner=new Scanner(tally);
		String kdString= aScanner.nextLine();
		String[] kdArray= kdString.split(",");
		this.wins= Integer.parseInt(kdArray[0]);
		this.losses= Integer.parseInt(kdArray[1]);
		
		aScanner.close();
		
		return;
	}
	public void writeWL() throws IOException
	{
		FileWriter file= new FileWriter("kd.txt");
		String kdString= new String(this.wins+","+this.losses);
		file.write(kdString);
		file.flush();
		file.close();
		
		return;
		
	}
	public void playGame() throws IOException
	{
		
		String a;
		String yes="n";
		String currentWord=this.dictionary.chooseWord();
		
		boolean correct=false;
		int wordsl= currentWord.length();
		char[] words= new char[wordsl];
		int guessesRemaining=5;
		System.out.print("Would you like to play? Y/N");
		a=input.nextLine();
		
		while(a!=yes)
			
		{
			for (int i=0; i<wordsl; i++)
			{
				words[i]= currentWord.charAt(i);
			}
		
				
		
		char[] guessed= new  char[wordsl];
		
	
		
		
		while (guessesRemaining > 0) 
		{
			System.out.printf("%d Letter Word\nYou have %d guesses left.\n", wordsl, guessesRemaining);
			for (char c: guessed)
			{
				System.out.print(c);
			}
			System.out.print("\n");
			String attempt = input.nextLine().toLowerCase();
			char attemptLetter = attempt.charAt(0);
			boolean letterFound = false;
			for (int i=0;i<wordsl;i++) {
				char letter = currentWord.charAt(i);
				if (attemptLetter == letter) {
					guessed[i] = letter;
					letterFound = true;
				}
			}
			if (letterFound) {
				System.out.printf("There is a "+ attempt+".");
			} else {
				System.out.printf("There is no "+attempt+".");
				guessesRemaining--;
			}
			
			
			boolean theyEqual = false;
			int match = 0;
			for (int i=0;i<wordsl;i++) {
				if (guessed[i]==words[i]) {
					match++;
				}
			}
			if (match == wordsl) {
				theyEqual = true;
			}
			if (theyEqual) {
				correct= true;
				break;
			}
		}
		if (correct) {
			this.wins++;
		} else {
			this.losses++;
		}
		this.writeWL();
		input.close();
		
				
}
		
	}
			
			
			
			
			
			
	}

	
	
	


