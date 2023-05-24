import java.io.*;
import java.util.*;
//import java.util.Scanner;


public class wordleSolver {

	public void solveWordle(){	
		
	char[] correctChars = {'a', 'b', 'z'};
	char[] incorrectChars = {'g', 'w', 'l', 'k'};
	Set<String> answers = findWords(correctChars, incorrectChars);
	if(answers.size() == 0){
		System.out.println("Invalid combination of letters");
	}
	else{
		System.out.println("Possible answers include: ");
		for(String answer:answers){
			System.out.print(answer + ", ");
		}
	}


	}

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
			return words;
	

		}catch(IOException E){
			return words;
		}
		
	}
}