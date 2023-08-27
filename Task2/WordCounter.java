import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        int wordCount = countWords(input);
        String[] words = splitIntoWords(input);

        System.out.println("Total number of words: " + wordCount);

        scanner.close();

    }

    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] words = input.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    public static String[] splitIntoWords(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        return input.split("[\\s\\p{Punct}]+");
    }
}
