import java.util.Stack;

public class PIP {
    static String evaluatePostfix(String input) {

        //extracts the input as a string
        String string = input;

        //defines all of the variables & stack
        int output = string.charAt(0);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {

            //reads every character of the string
            char read = string.charAt(i);

            //adds every variable/digit to stack
            if (Character.isLetterOrDigit(read)) {

                stack.push(Integer.valueOf(read));

            } else {

                int answer = stack.pop() + stack.pop();
                stack.push(answer);
                a

            }
        }

        output = output + stack.pop();

        return String.valueOf(output);
    }

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
            if (Character.isLetterOrDigit(read)) {

                output = output + read;

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

                        output = output + stack.pop();
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

                        output = output + stack.pop();

                    }

                    stack.push(read);
                }

            }
            //runs only when a closed parenthesis is found
            else if (read != ' ') {

                while (!stack.isEmpty() && stack.peek() != '(') {

                    output = output + stack.pop();


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

            output = output + stack.pop();

        }

        //returns the output
        return output;
    }
}