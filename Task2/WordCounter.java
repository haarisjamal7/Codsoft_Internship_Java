import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCounter {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText = "";

        try {
            System.out.println("Choose an option:");
            System.out.println("1. Enter a text");
            System.out.println("2. Provide a file");

            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter a text: ");
                    inputText = reader.readLine();
                    break;
                case 2:
                    System.out.print("Enter the file path: ");
                    String filePath = reader.readLine();
                    inputText = readFile(filePath);
                    break;
                default:
                    System.out.println("Invalid option. Exiting.");
                    return;
            }

            int wordCount = countWords(inputText);
            System.out.println("Total words in the text: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        reader.close();
        return content.toString();
    }

    private static int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+"); // Split by spaces or punctuation
        return words.length;
    }
}
