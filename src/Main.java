public class Main {
    public static void main(String[] args) {

        System.out.println(PIP.evaluatePostfix("74+"));
        System.out.println(PIP.infixToPostfix("a + b * c + ( d * e + f ) * g"));
    }
}