public class PrintRoman {

    private PrintRoman() {
    }

    public static void Write(double result) {

        {
            StringBuilder str = new StringBuilder();
            while (result >= 100) {
                str.append("C");
                result -= 100;
            }
            while (result >= 90) {
                str.append("XC");
                result -= 90;
            }
            while (result >= 50) {
                str.append("L");
                result -= 50;
            }
            while (result >= 40) {
                str.append("XL");
                result -= 40;
            }
            while (result >= 10) {
                str.append("X");
                result -= 10;
            }
            while (result >= 9) {
                str.append("IX");
                result -= 9;
            }
            while (result >= 5) {
                str.append("V");
                result -= 5;
            }
            while (result >= 4) {
                str.append("IV");
                result -= 4;
            }
            while (result >= 1) {
                str.append("I");
                result -= 1;
            }
            System.out.print(str);
        }
    }
}
