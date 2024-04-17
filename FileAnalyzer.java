import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileAnalyzer {
    public static void main(String[] args) {
        //show error message if there is no filename argument
        if (args.length == 0) {
            System.out.println("Please specify the name of the file you want to count! example=> java TextCounter filename.java");
            return;
        }

        //get the filename from the first command-line argument
        String fileName = args[0];

        //initialize variables to keep track of char,word and line counts
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        //include BufferedReader for more efficient file reading
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            //while loop will run as long as the file has lines
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                //split the words by white space by using regular expression
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            //check for input/output errors
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        System.out.println("File " + fileName + " has");
        System.out.println(charCount + " characters");
        System.out.println(wordCount + " words");
        System.out.println(lineCount + " lines");
    }
}
