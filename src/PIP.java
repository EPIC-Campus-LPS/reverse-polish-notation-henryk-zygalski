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

                //reads whether it is a + or a -
            } else if (read == '+' || read == '-') {

                //checks if the stack is empty
                if (stack.size() == 0) {
                    System.out.println("added" + read);
                    stack.push(read);

                    //checks if the top of the stack is a + or -
                } else if (stack.peek() == '+' || stack.peek() == '-') {

                    output = output + stack.pop();
                    stack.push(read);

                    //pushes what's read if its not a + or -
                } else {
                    stack.push(read);
                }

                //reads whether it is a * or /
            } else if (read == '*' || read == '/') {

                //checks if the stack is empty
                if (stack.size() == 0) {
                    System.out.println("added" + read);
                    stack.push(read);

                    //checks if the top of the stack is a + or -
                } else if (stack.peek() == '+' || stack.peek() == '-') {

                    System.out.println("added" + read);
                    stack.push(read);

                    //pops the current stack peek and adds what's read
                } else {
                    output = output + stack.pop();
                    stack.push(read);
                }

            } else if (read == '(') {

                stack.push(read);

                while (read != ')') {
                    if (Character.isLetter(read)) {

                        output = output + read;

                        //reads whether it is a + or a -
                    } else if (read == '+' || read == '-') {

                        //checks if the stack is empty
                        if (stack.size() == 0) {
                            System.out.println("added" + read);
                            stack.push(read);

                            //checks if the top of the stack is a + or -
                        } else if (stack.peek() == '+' || stack.peek() == '-') {

                            output = output + stack.pop();
                            stack.push(read);

                            //pushes what's read if its not a + or -
                        } else {
                            stack.push(read);
                        }

                        //reads whether it is a * or /
                    } else if (read == '*' || read == '/') {

                        //checks if the stack is empty
                        if (stack.size() == 0) {
                            System.out.println("added" + read);
                            stack.push(read);

                            //checks if the top of the stack is a + or -
                        } else if (stack.peek() == '+' || stack.peek() == '-') {

                            System.out.println("added" + read);
                            stack.push(read);

                            //pops the current stack peek and adds whats read
                        } else {
                            output = output + stack.pop();
                            stack.push(read);
                        }
                    }
                }

                for (int c = 0; c > stack.size(); i++) {
                    if (read == ')') {
                        stack.pop();
                    } else {
                        output = output + stack.pop();

                    }
                }
            }
            //puts everything left in the stack into the output
            for (int s = 0; s <= stack.size(); s++) {
                if (stack.size() == 0) {
                    break;
                }
                System.out.println("popped" + stack.peek());
                output = output + stack.pop();
            }
        }
        //returns the output
        return output;
    }
}
