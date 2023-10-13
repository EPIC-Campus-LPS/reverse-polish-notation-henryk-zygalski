import java.util.Stack;

/**
 * PIP class provides methods for evaluating a postfix expression
 *
 * @author Cardin N, Connor B
 * @version 1.0, 10/6/2023
 * @see java.util.Stack
 */

public class PIP {

    /**
     * Evaluates the value of a postfix expression
     *
     * @param input postfix expression
     * @return value of the postfix expression
     */
    static String evaluatePostfix(String input) {

        //extracts the input as a string
        String string = input;

        //defines all of the variables & stack
        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        for (int i = 0; i < string.length(); i++) {

            //reads every character of the string
            char read = string.charAt(i);

            //adds every variable/digit to stack
            try {
                if (Character.isLetterOrDigit(read) && read != ' ') {

                    stack.push(Character.getNumericValue(read));

                } else if (read != ' ' && read == '+') {

                    //adds what's read
                    answer = stack.pop() + stack.pop();
                    stack.push(answer);

                } else if (read != ' ' && read == '-') {

                    //subtracts what's read
                    answer = -stack.pop() + stack.pop();
                    stack.push(answer);

                } else if (read != ' ' && read == '*') {

                    //multiplies what's read
                    answer = stack.pop() * stack.pop();
                    stack.push(answer);

                } else if (read != ' ' && read == '/') {

                    //divides what's read
                    answer = stack.pop() / stack.pop();
                    stack.push(answer);

                }
            }

            //if the code above doesn't work it throws an exception

            catch (Exception e){

                throw new IllegalArgumentException();

            }
        }

        //checks if there's more than one thing in the stack (this is another base case for exceptions)

        if (stack.size() > 1){

            throw new IllegalArgumentException();

    }

        //returns the final answer
        return String.valueOf(answer);
    }

    /**
     * translates infix to postfix
     *
     * @param input infix expression
     * @return returns expression in postfix from infix
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

            //initializes two variables
            int openParenthesis = 0;
            int closedParenthesis = 0;

            //counts the amount of closed and open parenthesis
            if (read == '('){

                openParenthesis++;

            } else if (read == ')'){

                closedParenthesis++;

            }

        }

        //checks if the amount of closed and open parenthesis are the same
        if (closedParenthesis != openParenthesis){

            throw new IllegalArgumentException();

        }


        for (int i = 0; i < string.length(); i++) {

            //reads every character of the string
            char read = string.charAt(i);
            //adds every letter to the output as it goes along
            if (Character.isLetterOrDigit(read)) {

                output += read;

            }

            //equivalent to running until finds an operator
            else if (read != ')' && read != ' ') {

                //pushes whatever read if stack is empty
                if (stack.isEmpty() || read == '(') {

                    stack.push(read);

                }

                //runs when the operator is * or /
                else if (read == '*' || read == '/') {

                    //checks if the top of the stack is * or /
                    if (stack.peek() == '*' || stack.peek() == '/') {

                        output += stack.pop();
                        stack.push(read);

                    }
                    //runs if top of stack is + or -
                    else {

                        stack.push(read);

                    }

                }

                //runs when the operator is + - or (
                else {

                    while (!stack.isEmpty() && stack.peek() != '(') {

                        output += stack.pop();

                    }

                    stack.push(read);
                }

            }
            //runs only when a closed parenthesis is found
            else if (read != ' ') {

                while (!stack.isEmpty() && stack.peek() != '(') {

                    output += stack.pop();


                }

                //once the open parenthesis is found it pops it
                if (stack.peek() == '(') {
                    stack.pop();
                }

            }

        }

        //empties out the stack when there is nothing to read
        while (!stack.isEmpty()) {

            //pops out the open parenthesis
            if (stack.peek() == '(') {

                stack.pop();

            }
            output += stack.pop();

        }

        //uses other method to check if valid

        try {

            evaluatePostfix(output);

        } catch (Exception e){

            throw new IllegalArgumentException();

        }

        //returns the output if valid expression
        return output;
    }
}