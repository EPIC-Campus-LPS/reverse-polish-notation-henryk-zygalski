/**
 * Main class
 *
 * @author Cardin N Connor B
 * @version 1.0 10/6/2023
 */
public class Main {
    public static void main(String[] args) {

        //System.out.println(PIP.evaluatePostfix("7 2 + 9 / 3 5 *"));
        System.out.println(PIP.infixToPostfix("a + b * c + ( d * e + f) * g "));
    }

}