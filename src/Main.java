public class Main {
    public String formula;
    StringBuilder mathematicalExpression;

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println("Input formula is " + args[0]);
        m.formula = args[0];
        m.mathematicalExpression = new StringBuilder(m.formula);
        while (!m.checkIfOnlyDigits()) {
            m.doSingleOperation();
        }
    }

    private void doSingleOperation() {
        raiseToPowerOperation();
        multiplyOperation();
        divisionOperation();
        additionOperation();
        subtractionOperation();
    }

    private void additionOperation() {
        int signPosition;
        int firstNumberStart = 0;
        int secondNumberEnd = mathematicalExpression.length()-1;
        double result;

        signPosition = mathematicalExpression.indexOf("+");
        if (signPosition == (-1)) {
            return;
        }

        for (int i = signPosition - 1; i >= 0; i--) {
            if (Character.isDigit(mathematicalExpression.charAt(i)) || mathematicalExpression.charAt(i) == '.') {
                firstNumberStart = i;
            } else {
                break;
            }
        }
        for (int i = signPosition + 1; i < mathematicalExpression.length(); i++) {
            if (Character.isDigit(mathematicalExpression.charAt(i)) || mathematicalExpression.charAt(i) == '.') {
                secondNumberEnd = i;
            } else {
                break;
            }
        }
        result = Double.parseDouble(mathematicalExpression.substring(firstNumberStart, signPosition)) +
                Double.parseDouble(mathematicalExpression.substring(signPosition + 1, secondNumberEnd + 1));
        mathematicalExpression.delete(firstNumberStart, secondNumberEnd+1);
        mathematicalExpression.insert(firstNumberStart, result);
        System.out.println(mathematicalExpression);
    }

    private void subtractionOperation() {

    }


    private void divisionOperation() {
    }

    private void multiplyOperation() {
    }

    private void raiseToPowerOperation() {
        int signPosition;
        int baseStart = 0;
        int powerEnd = mathematicalExpression.length()-1;
        signPosition = mathematicalExpression.indexOf("^");
        if (signPosition == (-1)) {
            return;
        }

        for (int i = signPosition - 1; i >= 0; i--) {
            if (Character.isDigit(mathematicalExpression.charAt(i)) || mathematicalExpression.charAt(i) == '.') {
                baseStart = i;
            } else {
                break;
            }
        }
        double base = Double.parseDouble(mathematicalExpression.substring(baseStart, signPosition));

        for (int i = signPosition + 1; i < mathematicalExpression.length(); i++) {
            if (Character.isDigit(mathematicalExpression.charAt(i)) || mathematicalExpression.charAt(i) == '.') {
                powerEnd = i;
            } else {
                break;
            }
        }
        double power =  Double.parseDouble(mathematicalExpression.substring(signPosition+1, powerEnd+1));
        System.out.println("raise to power calculation");
        System.out.println(base);
        System.out.println(power);
        double result = Math.pow(base, power);
        System.out.println("result is");
        System.out.println(result);
        System.out.println("Raise to power works correctly");
        mathematicalExpression.delete(baseStart, powerEnd+1);
        mathematicalExpression.insert(baseStart, result);




    }




    public boolean checkIfOnlyDigits() {
        for (int i = 0; i < mathematicalExpression.length(); i++) {
            if (!Character.isDigit(mathematicalExpression.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}