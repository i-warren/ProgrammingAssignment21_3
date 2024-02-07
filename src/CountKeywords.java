import java.util.*;
import java.io.*;

public class CountKeywords {
    public static void main(String[] args) throws Exception {
        // Check for command line argument
        if (args.length != 1) {
            System.out.println("Usage: java sourceFile");
            System.exit(1);
        }




        File file = new File(args[0]);
        if (file.exists()) {
            System.out.println("The number of keywords in " + args[0]
                    + " is " + countKeywords(file));
        }
        else {
            System.out.println("File " + args[0] + " does not exist");
        }
    }

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

        Set<String> keywordSet =
                new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();
            // TODO COMMENT if "//"" don't count
            if (){

            }
            // TODO STRING elseif "\"" don't count while not "\"
            // TODO BLOCK COMMENT else if "/*" don't count while not "*/"

            if (keywordSet.contains(word))
                count++;
        }

        return count;
    }
}