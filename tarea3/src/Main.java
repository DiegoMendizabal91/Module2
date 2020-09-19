import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Sentence> senteceList = new ArrayList<Sentence>();
        Set<Word> words = new HashSet<>();
        Map<String, Double> wordScores = new HashMap<>();

        senteceList = Analyzer.readFile("src/reviews.txt");
        words = Analyzer.allWords(senteceList);
        wordScores = Analyzer.calculateScores(words);
        String sentence = "Mboscodictosaurio More vaudeville show than well-constructed narrative , but on those terms it 's inoffensive and actually rather sweet .";
        double sentenceScore = Analyzer.calculateSentenceScore(wordScores, sentence);
        System.out.println("The sentiment score is " + sentenceScore);
    }
}