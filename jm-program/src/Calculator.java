import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.print("Input:\n");
        Scanner reader = new Scanner(System.in);
        String text = reader.nextLine();
            try {
                DataCheck.read(text);
                if(DataCheck.isFlag()){
                    int result = (int) Solve.calculate(DataCheck.getNum1(),
                            DataCheck.getNum2(),
                            DataCheck.getOper());
                    System.out.print("Output:\n");
                    PrintRoman.Write(result);
                }
                if(!DataCheck.isFlag()){
                    int result = (int) Solve.calculate(DataCheck.getNum1(),
                            DataCheck.getNum2(),
                            DataCheck.getOper());
                    System.out.print("Output:\n");
                    System.out.println(result);
                }
            } catch (RuntimeException e) {
                System.out.print("Output:\n");
                System.err.println(e.getMessage());
            }
    }
}