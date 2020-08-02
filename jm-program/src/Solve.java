public class Solve {
    private Solve(){}

    public static double calculate(int number1, int number2, char operation){
        double result = 0;
        switch (operation){
            case '+': result = number1 + number2; break;
            case '-': result = number1 - number2; break;
            case '*': result = number1 * number2; break;
            case '/': result = number1 / number2; break;
            default:
        }
        return result;
    }
}
