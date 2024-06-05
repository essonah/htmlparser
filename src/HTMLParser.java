import java.util.Scanner;
import java.io.*;

/**
 * Hia Ghosh's 205 DS class.
 * 
 * @author amanda
 *
 */
public class HTMLParser {
    // a queue to store all html tags extracted from the file.
    private QueueLL<String> queue = new QueueLL<>(); // creates a queue of type QUEUELL to store all extracted tags

    // a stack to keep track of the tags and to ensure they are properly matched
    private StackLL<String> stack = new StackLL<>(); // creates a stack of type STACKLL

    /**
     * Reads in a file and saves all the HTML tags in a queue.
     * 
     * @param filename the file to read from
     * @throws FileNotFoundException if the file does not existnnn
     */
    public void extractTagsFromFile(String filename) throws FileNotFoundException {
        // Open the file for reading
        File infile = new File(filename);
        Scanner dataIn = new Scanner(infile);

        // Go through each line in the file and extract the tags found
        String line;
        while (dataIn.hasNextLine()) {
            // Get the next line
            line = dataIn.nextLine();

            // initialize the startIndex for finding the tags
            int startIndex = 0;

            // loops through the line to find the tags and adds the appropriate tags to the
            // queue.
            while (startIndex != -1) {

                // finds the start of the tag
                startIndex = line.indexOf('<', startIndex);

                // finds the end of the tag
                int endIndex = line.indexOf('>', startIndex + 1);

                if (startIndex != -1 && endIndex != -1) {

                    String tag = line.substring(startIndex, endIndex + 1).trim().toLowerCase();
                    // handles tags that have attributes , by taking out the attributes from the
                    // tags.
                    int spcIndex = tag.indexOf(" ");
                    if (spcIndex != -1) {
                        if (!tag.endsWith("/>")) {
                            tag = tag.substring(0, spcIndex) + ">";
                        }
                    }
                    // only enqueue the tag if it is not a self-closing tag
                    if (!isSelfClosingTag(tag)) {
                        queue.enqueue(tag);

                    }
                    // move the startIndex to begin after a tag has been found.
                    startIndex = endIndex + 1;
                } else {
                    // break the loop if no more tags can be found
                    break;
                }
            }

            // tags to a queue
            System.out.println(line);
        }

        // Close the Scanner when done
        dataIn.close();
    }

    /**
     * Check that the tags that were extracted pair up correctly.
     * 
     * @return true if all the tags extracted from the file pair up correctly.
     */

    public boolean checkTags() {
        while (!queue.isEmpty()) {
            // removes the current tag from the queue
            String tag = queue.dequeue();
            // if the tag is an opening tag, push it into the stack.
            if (isOpeningTag(tag)) {
                stack.push(tag);

            } else if (isClosingTag(tag)) {
                if (stack.isEmpty()) {
                    return false; // No opening tag for this closing tag
                }
                String openingTag = stack.pop();// pop the opening tag from the stack

                // checks if the popped tag matches the current tag.
                if (!isMatchingTag(openingTag, tag)) {
                    return false; // Mismatched tags
                }
            }
        }
        return stack.isEmpty(); // True if all tags matched correctly, false if there are unmatched opening tags
    }

    /**
     * checks if the tag is an opening tag
     * 
     * @param tag
     * @return true if it is an opening tag
     */
    private boolean isOpeningTag(String tag) {
        return tag.startsWith("<") && !tag.startsWith("</");
    }

    /**
     * checks if a tag is a closing tag.
     * 
     * @param tag
     * @return true if it is a closing tag
     */
    public boolean isClosingTag(String tag) {
        return tag.startsWith("</");
    }

    /**
     * 
     * @param openingTag
     * @param closingTag
     * @return true if the openingTag and closingTags match
     */
    public boolean isMatchingTag(String openingTag, String closingTag) {
        String openTagString = openingTag.substring(1, openingTag.length() - 1);
        String closingTagString = closingTag.substring(2, closingTag.length() - 1);
        return openTagString.equals(closingTagString);

    }

    /**
     * 
     * @param tag
     * @return true if they are selfClosingtags
     *         These are the self-closing tags in the HTML files, this makes
     *         provision
     *         to prevent them from getting added to the queue.
     */
    private boolean isSelfClosingTag(String tag) {
        // Directly check for self-closing tags
        if (tag.equals("<br>") || tag.equals("<br/>") ||
                tag.equals("<hr>") || tag.equals("<hr/>") ||
                tag.equals("<img>") || tag.equals("<img/>")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        HTMLParser parser = new HTMLParser();

        // Get all the tags out of the file
        parser.extractTagsFromFile(args[0]);

        // Check that the tags pair up correctly.

        if (parser.checkTags()) {
            System.out.println("No errors found in html file");
        } else {
            System.out.println("Error found");
        }
    }
}