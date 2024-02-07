import java.util.*;
import java.io.*;

/**
 * CountKeywords takes a command line argument of a java file and counts the java keywords.
 * It ignores keywords found in Strings, line comments, and block comments.
 * @author Isaac Warren
 */
public class CountKeywords {
    public static void main(String[] args) throws Exception {
        // Check for command line argument
        if (args.length != 1) {
            System.out.println("Usage: java sourceFile");
            System.exit(1);
        }

        // Check for file and display count of keywords
        File file = new File(args[0]);
        if (file.exists()) {
            System.out.println("The number of keywords in " + args[0]
                    + " is " + countKeywords(file));
        }
        else {
            System.out.println("File " + args[0] + " does not exist");
        }
    }

    /** countKeywords takes a File object and counts java keywords within
     * while ignoring Strings, comments and block comments*/
    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        // creates HashSet for efficiency
        Set<String> keywordSet =
                new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();

            if (word.equals("//")){// ignores line comment
                input.nextLine();
            } else if (word.equals("\"")) {// starts ignore of String
                String nextWord;
                do {
                    nextWord = input.next();
                } while (!nextWord.contains("\"")); //ends ignore of String

            } else if (word.contains("/*")) {   // start ignore of block comment
                String nextWord;
                do {
                    nextWord = input.next();
                } while (!nextWord.contains("*/")); //end ignore of block comment

            } else if (keywordSet.contains(word)) { // count keyword
                count++;
            }
        }
        return count;
    }
}