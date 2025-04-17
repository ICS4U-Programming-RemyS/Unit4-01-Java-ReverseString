import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**.
* This is the package-info.java file
*
* This program will read an multiple lines of strings from the a input file.
* It will then reverse those string using recursion and
* print the reversed strings to the output file.
*
* @author Remy Skelton
* @version 1.0
* @since 2025-04-17
*/

final class ReverseString {

    /**
     * This is a constant for the array size.
     */
    public static final int ARRAY_SIZE = 10;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        System.out.println("Welcome to the Reverse String program!");
        System.out.print("This program reads multiple lines");
        System.out.print(" of strings from input.txt, reverses them, and ");
        System.out.println("writes the result to output.txt.");

        // Read from input.txt
        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);

        // Make outputWriter to write to output.txt
        FileWriter outputWriter = new FileWriter("output.txt");

        // Create outputStr
        String outputStr = "";
        // While loop to read String from input.txt
        while (scanner.hasNextLine()) {
            // Set line equal to the next line
            String line = scanner.nextLine();

            // Call the recReverse method
            String reversedLine = recReverse(line);

            // Add the reversed line to the output string
            outputStr += "The reverse of "
                    + line + " is "
                    + reversedLine + "\n";

        }

        // Write the output string to output.txt
        outputWriter.write(outputStr);

        // Print the reversed array to the console
        System.out.println("Reversed Words written to output.txt.");
        // Close the scanner
        scanner.close();

        // Close the output writer
        outputWriter.close();
    }
    /**
     * This method reverses a string using recursion.
     *
     * @param word The string to be reversed.
     * @return The reversed string.
     */
    public static String recReverse(final String word) {
        // Check if the word is empty
        if (word.isEmpty()) {
            // Return the empty string
            return word;
        } else {
            // Call the recReverse method without the first character
            // and add the first character to the end of the string
            return recReverse(word.substring(1)) + word.charAt(0);
        }
    }
}
