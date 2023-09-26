import java.util.Stack;

public class PIP {

    /*
    static String evaluatePostfix (String input){

    }
     */

    static String infixToPostfix(String input) {

        //extracts the input as a string
        String string = input;

        //defines the output & stack
        String output = null;
        Stack<Integer> stackName = new Stack<>();


        for (int i = 0; i <= string.length(); i++) {

            //reads every character of the string
            char read = string.charAt(i);

            //adds every letter to the output
            if (Character.isLetter(read)) {
                output = output + read;

            } else {



            }
        }
    }
}
