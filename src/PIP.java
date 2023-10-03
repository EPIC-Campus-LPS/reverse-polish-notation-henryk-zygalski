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
        String output = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {

            //reads every character of the string
            char read = string.charAt(i);

            //adds every letter to the output as it goes along
            if (Character.isLetter(read)) {

                output = output + read;

            }

            //equivalent to running until finds an operator
            else if (read != ')') {

                //pushes whatever read if stack is empty
                if (stack.isEmpty() || read == '(') {

                    stack.push(read);

                }

                //runs when the operator is * or /
                else if (read == '*' || read == '/') {

                    //checks if the top of the stack is * or /
                    if (stack.peek() == '*' || stack.peek() == '/') {

                        output = output + stack.pop();
                        stack.push(read);

                    }
                    //runs if top of stack is + or -
                    else {

                        stack.push(read);

                    }

                }

                //runs when the operator is + or -
                else {

                    for (int m = 0; m <= stack.size(); m++){

                        output = output + stack.pop();

                    }

                    stack.push(read);

                }

            }
            //runs only when an open or closed parenthesis is found
            else {

                for (int x = 0; x < stack.size(); x++){

                    if (stack.peek() == '('){

                        stack.pop();

                    } else {

                        output = output + stack.pop();

                    }

                }

            }

        }

        while (!stack.isEmpty()){

            output = output + stack.pop();

        }

        //returns the output
        return output;
    }
}