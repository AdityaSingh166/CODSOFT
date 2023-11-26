import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text or provide a file path:");
        String input = scanner.nextLine();
        File file = new File(input);
        if (file.exists() && file.isFile()) {
            try {
                input = new String(Files.readAllBytes(file.toPath()));
            } catch (IOException e) {
                System.out.println("Error reading the file. Exiting.");
                return;
            }
        }
        String[] words = input.split("\\s+|\\p{Punct}+");
        int wordCount = 0;
        String[] stopWords = {"the", "and", "in", "to", "of", "a", "for", "on", "with", "at"};
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
                if (!isStopWord(word.toLowerCase())) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }
        System.out.println("Total number of words: " + wordCount);
        System.out.println("Number of unique words: " + wordFrequency.size());
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    private static boolean isStopWord(String word) {
        String[] stopWords = {"the", "and", "in", "to", "of", "a", "for", "on", "with", "at"};
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }
}
