import java.io.*;
import java.util.*;

/**
 * The MorseCode program uses Binary Search Trees to decode a Morse Code file into
 * plain English and encode an story written in English into Morse Code.
 *
 * @author Joseph Prostko
 * @version December 2018
 */

public class MorseCode {
    // The TreeMap toCode will hold the values of the letters of the alphabet
    // and their corresponding morse code value.
    TreeMap<Character, String> toCode = new TreeMap<Character, String>();

    // The root TreeNode will grow into a tree which can be properly navigated
    // to decode a Morse Code message into plain text.
    TreeNode<Character> root = new TreeNode<>('&');

    /**
     * The default constructor for MorseCode which reads in the values of the MorseCode.txt
     * file and populates each data structure accordingly.
     */
    public MorseCode() {
        // Scanner file is declared.
        Scanner file = null;

        // The try catch statement catch any FileNotFoundException while reading in the file.
        try {
            // file Scanner is set to scan the MorseCode.txt file.
            file = new Scanner(new File("MorseCode.txt"));

            // the catch statement handles the FileNotFoundException.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // The tempHash HashMap will collect each letter with morse code in the file.
        // The logic behind doing this is that TreeNode's nodes will be set one at a time
        // with the shortest Morse Code values being read in first, so there is not a Null
        // PointerException at any point.
        HashMap<Character, String> tempHash = new HashMap<>();

        // The lengthOne HashMap will hold each character and corresponding morse code with a length of one.
        HashMap<Character, String> lengthOne = new HashMap<>();

        // The lengthTwo HashMap will hold each character and corresponding morse code with a length of two.
        HashMap<Character, String> lengthTwo = new HashMap<>();

        // The lengthThree HashMap will hold each character and corresponding morse code with a length of three.
        HashMap<Character, String> lengthThree = new HashMap<>();

        // The lengthFour HashMap will hold each character and corresponding morse code with a length of four.
        HashMap<Character, String> lengthFour = new HashMap<>();

        // The while statement will run as long as the file has more data to be read in.
        while (file.hasNext()) {
            // The char temp holds the temporary character of each letter in the alphabet.
            char temp = file.next().charAt(0);

            // The String tempString holds the corresponding morse code value for each letter.
            String tempString = file.next();

            // The letter and morse code are placed in toCode.
            toCode.put(temp, tempString);

            // The letter and morse code are placed in tempHash.
            tempHash.put(temp, tempString);
        }

        // The for statement will read in the first values of the tempHash and place them in lengthOne.
        for (char i = 'A'; i <= 'Z'; i++) {
            // The first if statement determines if the letter value of each value in tempHash
            // has a corresponding morse code value with a length of 1.
            if (tempHash.get(i).length() == 1) {
                // The value is placed in lengthOne.
                lengthOne.put(i, tempHash.get(i));

                // The second else if statement determines if the letter value of each value in tempHash
                // has a corresponding morse code value with a length of 2.
            } else if (tempHash.get(i).length() == 2) {
                // The value is placed in lengthTwo.
                lengthTwo.put(i, tempHash.get(i));

                // The third else if statement determines if the letter value of each value in tempHash
                // has a corresponding morse code value with a length of 3.
            } else if (tempHash.get(i).length() == 3) {
                // The value is placed in lengthThree.
                lengthThree.put(i, tempHash.get(i));

                // The else statement determines if the letter value of each value in tempHash
                // has a corresponding morse code value with a length of 4.
            } else {
                // The value is placed in lengthFour.
                lengthFour.put(i, tempHash.get(i));
            }
        }

        // The first for statement will read in each value of lengthOne from tempHash.
        for (char i = 'A'; i <= 'Z'; i++) {

            // The if statement determines if lengthOne contains the current letter.
            if (lengthOne.containsKey(i)) {

                // The char[] charArray is set as the value of the current letter in lengthOne[i]'s morse code value.
                char[] charArray = lengthOne.get(i).toCharArray();

                // The for loop below reads in each value from charArray.
                for (int j = 0; j < charArray.length; j++) {

                    // If the charArray[j] value is equal to '.', the root.left is set to a new TreeNode with character i.
                    if (charArray[j] == '.')

                        // root.left is set as a new TreeNode<Character>(i).
                        root.left = new TreeNode<Character>(i);

                        // If the charArray[j] value is equal to '-', the root.right is set to a new TreeNode with character i.
                    else

                        // root.right is set as a new TreeNode<Character>(i).
                        root.right = new TreeNode<Character>(i);
                }
            }
        }

        // The second for statement will read in each value of lengthTwo from tempHash.
        for (char i = 'A'; i <= 'Z'; i++) {

            // The if statement determines if lengthTwo contains the current letter.
            if (lengthTwo.containsKey(i)) {

                // The TreeNode<Character> is set as the root TreeNode<Character>.
                TreeNode<Character> current = root;

                // The char[] charArray is set as the value of the current letter in lengthTwo[i]'s morse code value.
                char[] charArray = lengthTwo.get(i).toCharArray();

                // The for loop below reads in each value from charArray.
                for (int j = 0; j < charArray.length; j++) {

                    // The if statement below determines if the current morse code digit is the first one.
                    if (j == 0) {

                        // The if statement below determines if the current charArray[j] character is '.'.
                        if (charArray[j] == '.') {

                            // current is set to root.left.
                            current = root.left;
                        }

                        // The if statement below determines if the current charArray[j] character is '-'.
                        else {

                            // current is set to root.right.
                            current = root.right;
                        }
                    }

                    // The else if statement below determines if the charArray[j] value is '.'.
                    else if (charArray[j] == '.')

                        // current.left is set as a new TreeNode<Character>(i).
                        current.left = new TreeNode<Character>(i);

                        // The else statement below determines if the charArray[j] value is '-'.
                    else

                        // current.right is set as a new TreeNode<Character>(i).
                        current.right = new TreeNode<Character>(i);
                }
            }
        }

        // The third for statement will read in each value of lengthThree from tempHash.
        for (char i = 'A'; i <= 'Z'; i++) {

            // The if statement determines if lengthThree contains the current letter.
            if (lengthThree.containsKey(i)) {

                // The TreeNode<Character> is set as the root TreeNode<Character>.
                TreeNode<Character> current = root;

                // The char[] charArray is set as the value of the current letter in lengthThree[i]'s morse code value.
                char[] charArray = lengthThree.get(i).toCharArray();

                // The for loop below reads in each value from charArray.
                for (int j = 0; j < charArray.length; j++) {

                    // The if statement below determines if the current morse code digit is not the last digit.
                    if (j < 2) {

                        // The if statement below determines if the current charArray[j] character is '.'.
                        if (charArray[j] == '.') {

                            // current is set to root.left.
                            current = current.left;
                        }

                        // The else statement below determines if the charArray[j] value is '-'.
                        else {

                            // current is set to root.right.
                            current = current.right;
                        }
                    }

                    // The else if statement below determines if the charArray[j] value is '.'.
                    else if (charArray[j] == '.')

                        // current.left is set as a new TreeNode<Character>(i).
                        current.left = new TreeNode<Character>(i);

                        // The else statement below determines if the charArray[j] value is '-'.
                    else

                        // current.right is set as a new TreeNode<Character>(i).
                        current.right = new TreeNode<Character>(i);
                }
            }
        }

        // The fourth for statement will read in each value of lengthFour from tempHash.
        for (char i = 'A'; i <= 'Z'; i++) {

            // The if statement determines if lengthFour contains the current letter.
            if (lengthFour.containsKey(i)) {

                // The TreeNode<Character> is set as the root TreeNode<Character>.
                TreeNode<Character> current = root;

                // The char[] charArray is set as the value of the current letter in lengthFour[i]'s morse code value.
                char[] charArray = lengthFour.get(i).toCharArray();

                // The for loop below reads in each value from charArray.
                for (int j = 0; j < charArray.length; j++) {

                    // The if statement below determines if the current morse code digit is not the last digit.
                    if (j < 3) {

                        // The if statement below determines if the current charArray[j] character is '.'.
                        if (charArray[j] == '.') {

                            // current is set to root.left.
                            current = current.left;
                        }

                        // The else statement below determines if the charArray[j] value is '-'.
                        else {
                            // current is set to root.right.
                            current = current.right;
                        }
                    }

                    // The else if statement below determines if the charArray[j] value is '.'.
                    else if (charArray[j] == '.')

                        // current.left is set as a new TreeNode<Character>(i).
                        current.left = new TreeNode<Character>(i);

                        // The else statement below determines if the charArray[j] value is '-'.
                    else

                        // current.right is set as a new TreeNode<Character>(i).
                        current.right = new TreeNode<Character>(i);
                }
            }
        }
    }

    /**
     * The inner class TreeNode creates the TreeNodes that will be used in this assignment.
     *
     * @param <Character> casts the element within each TreeNode to a character.
     */
    public static class TreeNode<Character> {
        // The Character element holds the letter value of each TreeNode.
        protected Character element;

        // The TreeNode left determines the node which is to the left of the current TreeNode.
        protected TreeNode<Character> left;

        // The TreeNode left determines the node which is to the left of the current TreeNode.
        protected TreeNode<Character> right;

        /**
         * The default constructor of TreeNode contains no character element.
         */
        public TreeNode() {
        }

        /**
         * The next constructor of TreeNode inserts the specific character value as element from the parameter.
         *
         * @param element the character specified in the parameter that will be set as the element of that TreeNode.
         */
        public TreeNode(Character element) {

            // The current TreeNode's element is set as the element value from the parameter.
            this.element = element;
        }
    }

    /**
     * The createNewNode method creates a new TreeNode with the specified elmeent value.
     *
     * @param e
     * @return a new TreeNode with the specified element value.
     */
    protected TreeNode<Character> createNewNode(Character e) {

        // A new TreeNode with the specified character value is returned.
        return new TreeNode<Character>(e);
    }


    /**
     * The lookUp method returns the value of the character with the entered morse code.
     *
     * @param code the entered Morse Code.
     * @return the character corresponding to the Morse Code entered.
     */
    Character lookUp(String code) {
        // The current value is initialized to root.
        TreeNode<Character> current = root;

        // A char array codeArray is set as an array of the entered Morse Code characters.
        char[] codeArray = code.toCharArray();

        // The for loop below reads in each value of the codeArray[] and moves down the TreeNode tree accordingly.
        for (int i = 0; i < codeArray.length; i++) {

            // The if statement determines if the current digit of codeArray[i] is '.'.
            if (codeArray[i] == '.') {

                // The value of current is moved to current.left.
                current = current.left;

                // The else statement determines if the current digit of codeArray[i] is '-'.
            } else current = current.right;
        }

        // The current element is returned.
        return current.element;
    }

    /**
     * The encodeFile method takes a file written in English and returns a new file containing the
     * morse code of the file inserted.
     *
     * @param inputFilename  The name of the file to be translated into Morse Code.
     * @param outputFilename The name of the file returned in Morse Code.
     * @throws Exception IOException
     */
    public void encodeFile(String inputFilename, String outputFilename) throws Exception {
        // The Scanner input is declared.
        Scanner input = null;

        // The PrintWriter output is declared.
        PrintWriter output = null;

        // The try-catch block catches an instance of an IOException.
        try {
            // input is set to scan the file specified in the parameter.
            input = new Scanner(new File(inputFilename));

            // output is set to print the file with the filename specified in the parameter.
            output = new PrintWriter(new FileOutputStream(outputFilename));

            // The while loop will print output as long as there is data to be read in.
            while (input.hasNext()) {

                // All puncuation is removed from the next line of input and saved as temp.
                String temp = input.nextLine().replaceAll("\\p{P}", "");

                //The next line of the file being scanned is saved as a character array.
                char[] characters = temp.toCharArray();

                // The for loop reads in each character of characters.
                for (int i = 0; i < characters.length; i++) {

                    // If characters[i] is an empty space, then "*" is printed to the output file.
                    if (characters[i] == ' ') {

                        // "*" is printed to the output file.
                        output.println("*");

                        // If characters[i] is just a regular letter, else is called.
                    } else

                        // The character is entered into toCode and the corresponding Morse Code is printed.
                        output.println(toCode.get(characters[i]));
                }

                // A "+" is printed to signify the end of the current line.
                output.println("+");

            }
            // an IOException is caught and handled.
        } catch (IOException e) {

            // e is printed.
            System.out.println(e);

            // finally, the output is closed.
        } finally {
            output.close();
        }
    }

    /**
     * decodeFile takes a file written in Morse Code and prints its meaning in English into a new file.
     *
     * @param inputFilename  The file written in Morse Code to be decoded.
     * @param outputFileName The file written in English from the decoded Morse Code.
     * @throws Exception IOException
     */
    public void decodeFile(String inputFilename, String outputFileName) throws Exception {

        // The Scanner input is declared.
        Scanner input = null;

        // The PrintWriter output is declared.
        PrintWriter output = null;

        // The try-catch block catches an instance of an IOException.
        try {
            // input is set to scan the file specified in the parameter.
            input = new Scanner(new File(inputFilename));

            // output is set to print the file with the filename specified in the parameter.
            output = new PrintWriter(new FileOutputStream(outputFileName));

            // The while loop will print output as long as there is data to be read in.
            while (input.hasNext()) {

                // String temp holds the value of the next line of the file being scanned.
                String temp = input.nextLine();

                // The if statement determines if the temporary line is just an "*".
                if (temp.equals("*")) {

                    // If so, a space is printed.
                    output.print(" ");

                    // The else if statement checks if the temporary lien is just "+".
                } else if (temp.equals("+")) {

                    // If so, a carriage return is printed.
                    output.println();

                    // If the temp line is a morse code string, loopUp is called so the corresponding character is found.
                } else {

                    // The corresponding letter is printed.
                    output.print(lookUp(temp));
                }
            }
        } // an IOException is caught and handled.
        catch (IOException e) {

            // e is printed.
            System.out.println(e);

            // finally, the output is closed.
        } finally {
            output.close();
        }
    }

    /**
     * The main method will create a Morse Code object called in and it will decode
     *  and encode a file named decodedMcGee.txt and encodedMcGee.txt respectively.
     * @param args the arguments being processed in the main method.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // A new morse code object in is declared and instantiated.
        MorseCode in = new MorseCode();

        // in.decodeFile is called to decode mgee.encoded and return a new translated decodedMcGee.txt.
        in.decodeFile("mcgee.encoded", "decodedMcGee.txt");

        // in.encodeFile is called to encode mcgee.txt and return a new encoded encodedMcGee.txt.
        in.encodeFile("mcgee.txt", "encodedMcGee.txt");
    }
}
