import java.util.Scanner;

public class Main {
    public StringBuilder formula;
    public static void main(String[] args) {
        Main m = new Main();

        System.out.println("Input formula is " + args[0]);
        m.formula = new StringBuilder(args[0]);
        System.out.println(m.checkIfOnlyDigits());
       /* while (!m.checkIfOnlyDigits()) {
            m.doSingleOperation();
        }*/
        m.doSingleOperation();

    }

    private void doSingleOperation() {
        raiseToPowerCheck();
        multiplyCheck();
        divisionCheck();
        additionCheck();
    }

    private void additionCheck() {
        int plusPosition;
        int firstNumberStart = 0;
        int secondNumberEnd = formula.length();
        double result;
        plusPosition = formula.indexOf("+");
        if (plusPosition == (-1)) {
            return;
        } else {
            for (int i = plusPosition-1; i > 0; i--) {
                if (Character.isDigit(formula.charAt(i)) || formula.charAt(i) == ',') {
                    firstNumberStart = i;
                } else {
                    break;
                }
            }
            for (int i = plusPosition + 1; i < formula.length(); i++) {
                if (Character.isDigit(formula.charAt(i)) || formula.charAt(i) == ',') {
                    secondNumberEnd = i;
                } else {
                    break;
                }
            }
        }
        System.out.println("Addition numbers coordinates calculated correctly");
        System.out.println(firstNumberStart);
        System.out.println(secondNumberEnd);
        result = Double.parseDouble(formula.substring(firstNumberStart, plusPosition)) +
                Double.parseDouble(formula.substring(plusPosition + 1, secondNumberEnd + 1));
        System.out.println(result);
        System.out.println("Addition works well");
    }

    private void raiseToPowerCheck() {
        
    }

    private void divisionCheck() {
    }

    private void multiplyCheck() {
    }

    public boolean checkIfOnlyDigits() {
        for (int i = 0; i < formula.length(); i++) {
            if (!Character.isDigit(formula.charAt(i))){
                return false;
            }
        }
        return true;
    }

}