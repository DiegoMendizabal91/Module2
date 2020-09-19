import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		List<Sentence> senteceList = new ArrayList<Sentence>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(" ",2);
				String scoreString = values[0];
				int score = Integer.parseInt(scoreString);
				String text = values[1];
				if (score >= -2 && score <= 2){
					Sentence currentSentence = new Sentence(score, text);
					senteceList.add(currentSentence);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return senteceList;
		}

		return senteceList; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		Set<Word> wordSet = new HashSet<>();
		List<Word> wordList = new ArrayList<>();

		for (int i = 0; i < sentences.size(); i++){
			String toLowerCase = sentences.get(i).text.toLowerCase();
			String[] wordsInLine = toLowerCase.split(" ");
			for (int j = 0; j < wordsInLine.length; j++){
				wordsInLine[j] = wordsInLine[j].replace("'s","");
				if((!(wordsInLine[j].equals(".")) && !(wordsInLine[j].equals(",")) && (wordsInLine[j].length() > 1))){
					if(j == 0){
						Word newWord = new Word(wordsInLine[j]);
						newWord.increaseTotal(sentences.get(i).score);
						wordList.add(newWord);
					}
					else {
						boolean duplicate = false;
						for (int h =0; h<wordList.size(); h++) {
							String wordsInl = wordsInLine[j];
							String wordLis = wordList.get(h).getText();
							if(wordsInLine[j].equals(wordList.get(h).getText())) {
								wordList.get(h).increaseTotal(sentences.get(i).score);
								duplicate = true;
								break;
							}
						}
						if (!(duplicate)){
							Word newWord = new Word(wordsInLine[j]);
							newWord.increaseTotal(sentences.get(i).score);
							wordList.add(newWord);
						}
					}
				}
			}
		}

		for (int k =0; k<wordList.size(); k++) {
			wordSet.add(wordList.get(k));
		}

		return wordSet; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		Map<String, Double> mapScoreCalculate = new HashMap<>();

		if (words != null) {
			for (Word temp : words) {
				mapScoreCalculate.put(temp.text, temp.calculateScore());
			}
		}

		return mapScoreCalculate;

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		double sentenceScore = 0;
		String toLowerCase = sentence.toLowerCase();
		String[] wordsInSentence = toLowerCase.split(" ");
		for (int i = 0; i < wordsInSentence.length; i++){
			if (startWithLetter(wordsInSentence[i])){
				if(wordScores.get(wordsInSentence[i]) == null){
					sentenceScore = 0 + sentenceScore;
				} else{
					sentenceScore = wordScores.get(wordsInSentence[i]) + sentenceScore;
				}
			}
		}

		
		return sentenceScore; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}


	public static boolean startWithLetter(String word){
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for( int i = 0 ; i < alphabet.length(); i++ ) {
			if(word.charAt(0) == alphabet.charAt(i)){
				return true;
			}
		}
		return false;
	}
}
