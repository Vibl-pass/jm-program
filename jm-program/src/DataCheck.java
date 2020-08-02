
public class DataCheck {
    public static boolean test;
    public static int number2;
    public static int number1;
    public static char operation;
    public static boolean flag = false;

    public static void read(String text) {
        String[] roman = {"I", "II", "III", "IV", "IX", "V", "VI", "VII", "VIII", "X"};
        try {
            String[] blocks = text.split("\\s");
            for (String s : roman) {
                if (s.equals(blocks[0]) || s.equals(blocks[2])) {
                    flag = true;
                    break;
                }
            }
            test = flag;
            if(flag){
                number1 = romanToNumber(blocks[0]);
                operation = blocks[1].charAt(0);
                number2 = romanToNumber(blocks[2]);
            } else {
                number1 = Integer.parseInt(blocks[0]);
                operation = blocks[1].charAt(0);
                number2 = Integer.parseInt(blocks[2]);
            }
            if ( operation == '%' ) {
                throw new IllegalArgumentException();
            }
            if ((number1 > 10 || number1 <= 0) || (number2 > 10 || number2 <= 0)) {
                throw new IllegalArgumentException();
            }
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException("Неверный формат данных");
        }
    }
    private static int romanToNumber(String roman) {
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return -1;
        }
    }
    public static int getNum1() {
        return number1;
    }

    public static int getNum2() {
        return number2;
    }

    public static char getOper() {
        return operation;
    }

    public static boolean isFlag(){
        return flag;
    }
}
