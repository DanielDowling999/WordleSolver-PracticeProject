import java.io.*;
import java.util.*;
//import java.util.Scanner;


public class wordleSolver {

	public Set<String> solveWordle(String correctLetters, String wrongLetters){	
	correctLetters = correctLetters.toLowerCase();
	wrongLetters = wrongLetters.toLowerCase();	
	char[] correctChars = correctLetters.toCharArray();
	char[] incorrectChars = wrongLetters.toCharArray();
	Set<String> answers = findWords(correctChars, incorrectChars);
    /*for (char lets:correctChars){
		System.out.print(lets);
	}*/
	if(answers.size() == 0){
		System.out.println("Invalid combination of letters");
		answers = new HashSet<String>();
		answers.add("Invalid Combination of Letters");
	}
	else{
		System.out.println("Possible answers include: ");
		for(String answer:answers){
			System.out.print(answer + ", ");
		}
	}
	return answers;


	}
    //Scans dictionary (a text file that comes with the application) for any valid words, storing them in a Set if found.
	public Set<String> findWords(char[] correctChars, char[] incorrectChars){
		File file = new File("words.txt");
		Set<String> words = new HashSet<String>();
		Boolean escape = false;
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				String word = sc.next();
				for(int i = 0; i<incorrectChars.length; i++){
					if(word.indexOf(incorrectChars[i]) == -1){
						
					}
					else{
						escape = true;
						break;
					}
				}
				if(escape){
					escape = false;
					//continue;
				}
				else{
					for(int i =0; i<correctChars.length; i++){
						if(word.indexOf(correctChars[i]) == -1){
							escape = true;
							break;
						}
					}
					if(escape){
						escape = false;
					}
					else{
						words.add(word);

					}
				}
			}
			sc.close();
			return words;
	

		}catch(IOException E){
			return words;
		}
		
	}
}