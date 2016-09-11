package CS3213;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class KWIC {

	private static final String INPUT_INTRO = "Enter movie titles (terminate input by entering empty line) ";
	private static final String IGNORE_WORDS_INTRO = "Enter words to ignore (terminate input by entering empty line) ";
	private static final String REQUIRED_WORDS_INTRO = "Enter required words [Required words cannot be the same as any ignore word] (terminate input by entering empty line) ";
	private static final String ADDING_REQUIRED_WORDS_ERROR_MSG = "Required words cannot be the same as any words to ignore! The required word just entered will be discarded. Please continue your inputs below:";
	
	private void readInputs( Scanner reader, Collection<String> inputs, Conditions condition ) {
		
		assert(reader != null && inputs != null && condition != null);
		
		String userInput;
		while( reader.hasNextLine() ){
			
			userInput = reader.nextLine();
			if(userInput.isEmpty()){
				break;
			}
			
			if( condition.isAddable(userInput) ){
				inputs.add(userInput);
			}
			else{
				condition.notAddableResponse();
			}
		}
	}
	
	private void readInputs( Scanner reader, WordsCollection inputs, Conditions condition ) {
		
		assert(reader != null && inputs != null && condition != null);
		
		String userInput;
		while( reader.hasNextLine() ){
			
			userInput = reader.nextLine();
			if(userInput.isEmpty()){
				break;
			}
			
			if( condition.isAddable(userInput) ){
				inputs.addWord(userInput);
			}
			else{
				condition.notAddableResponse();
			}
		}
	}
	
	private void readRequiredWords( Scanner reader, WordsCollection inputs, final WordsCollection ignoreWords ) {
		
		assert(reader != null && inputs != null && ignoreWords != null);
		
		readInputs(reader, inputs, new Conditions() { 
			
			@Override
			public boolean isAddable( String str ){
				return !ignoreWords.contains(str);
			}
			
			@Override
			public void notAddableResponse() {
				System.out.println(ADDING_REQUIRED_WORDS_ERROR_MSG);
			}
		});
	}
	
	private void printProcessedLines( Collection<String> processedLines ) {
		
		assert(processedLines != null);
		
		String separator = System.lineSeparator();
		for( String line : processedLines ) {
			System.out.print(line);
			System.out.print(separator);
		}
	}
	
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> inputs = new ArrayList<String>();
		System.out.println(INPUT_INTRO);
		readInputs(sc, inputs, new Conditions());
		
		WordsCollection wordsToIgnore = WordsCollection.create();
		System.out.println(IGNORE_WORDS_INTRO);
		readInputs(sc, wordsToIgnore, new Conditions());
		
		WordsCollection requiredWords = WordsCollection.create();
		System.out.println(REQUIRED_WORDS_INTRO);
		readRequiredWords(sc, requiredWords, wordsToIgnore);
		
		Alphabetizer alphabetizer = Alphabetizer.create();
		ShiftFactory shiftFactory = ShiftFactory.getInstance();
        AbstractShift shifter = shiftFactory.getShifter(wordsToIgnore, requiredWords);
        for (String str : inputs) {
            alphabetizer.addLines(shifter.getShifts(str));
        }
		
        List<String> result = alphabetizer.getSortedLines();
        
        printProcessedLines(result);
        
		sc.close();
	}
	
	private class Conditions {
		
		public boolean isAddable( String str ){
			return true;
		}
		
		public void notAddableResponse() {}
	}
}