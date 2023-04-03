import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare marginal income and tax rates
        final double TAX_BRACKET_ONE = 0.10;
        final double TAX_BRACKET_TWO = 0.15;
        final double TAX_BRACKET_THREE = 0.25;
        final double TAX_BRACKET_FOUR = 0.28;
        final double TAX_BRACKET_FIVE = 0.33;
        final double TAX_BRACKET_SIX = 0.35;

        // Single income brackets
        final double SINGLE_INCOME_BRACKET_ONE = 8350;
        final double SINGLE_INCOME_BRACKET_TWO = 33950;
        final double SINGLE_INCOME_BRACKET_THREE = 82250;
        final double SINGLE_INCOME_BRACKET_FOUR = 171550;
        final double SINGLE_INCOME_BRACKET_FIVE = 372950;

        // Married filing jointly or qualified widow(er) income brackets
        final double JOINT_INCOME_BRACKET_ONE = 16700;
        final double JOINT_INCOME_BRACKET_TWO = 67900;
        final double JOINT_INCOME_BRACKET_THREE = 137050;
        final double JOINT_INCOME_BRACKET_FOUR = 208850;
        final double JOINT_INCOME_BRACKET_FIVE = 372950;

        // Married filing separately income brackets
        final double SEPARATE_INCOME_BRACKET_ONE = 8350;
        final double SEPARATE_INCOME_BRACKET_TWO = 33950;
        final double SEPARATE_INCOME_BRACKET_THREE = 68525;
        final double SEPARATE_INCOME_BRACKET_FOUR = 104425;
        final double SEPARATE_INCOME_BRACKET_FIVE = 186475;

        // Head of household income brackets
        final double HEAD_INCOME_BRACKET_ONE = 11950;
        final double HEAD_INCOME_BRACKET_TWO = 45500;
        final double HEAD_INCOME_BRACKET_THREE = 117450;
        final double HEAD_INCOME_BRACKET_FOUR = 190200;
        final double HEAD_INCOME_BRACKET_FIVE = 372950;

        // Prompt user to enter filing status
        System.out.println("(0) Single filer");
        System.out.println("(1) Married filing jointly");
        System.out.println("(2) Married filing separately");
        System.out.println("(3) Head of household");
        System.out.print("Enter your filing status: ");
        int filingStatus = input.nextInt();

        // Prompt user to enter taxable income
        System.out.print("Enter your taxable income: $");
        double taxableIncome;
        taxableIncome = input.nextDouble();

        // Initialise taxPayable variable
        double taxPayable = 0;

        // Compute tax based on filingStatus selection
        switch(filingStatus) {

            // Single income calculation
            case 0:
                if (taxableIncome <= SINGLE_INCOME_BRACKET_ONE) {
                    taxPayable = taxableIncome * TAX_BRACKET_ONE;
                }
                else if (taxableIncome <= SINGLE_INCOME_BRACKET_TWO) {
                    taxPayable = SINGLE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (taxableIncome - SINGLE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO;
                }
                else if (taxableIncome <= SINGLE_INCOME_BRACKET_THREE) {
                    taxPayable = SINGLE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (SINGLE_INCOME_BRACKET_TWO - SINGLE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (taxableIncome - SINGLE_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE;
                }
                else if (taxableIncome <= SINGLE_INCOME_BRACKET_FOUR) {
                    taxPayable = SINGLE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (SINGLE_INCOME_BRACKET_TWO - SINGLE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (SINGLE_INCOME_BRACKET_THREE - SINGLE_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (taxableIncome - SINGLE_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR;
                }
                else if (taxableIncome <= SINGLE_INCOME_BRACKET_FIVE) {
                    taxPayable = SINGLE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (SINGLE_INCOME_BRACKET_TWO - SINGLE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (SINGLE_INCOME_BRACKET_THREE - SINGLE_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (SINGLE_INCOME_BRACKET_FOUR - SINGLE_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR
                            + (taxableIncome - SINGLE_INCOME_BRACKET_FOUR) * TAX_BRACKET_FIVE;
                }
                else {
                    taxPayable = SINGLE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (SINGLE_INCOME_BRACKET_TWO - SINGLE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (SINGLE_INCOME_BRACKET_THREE - SINGLE_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (SINGLE_INCOME_BRACKET_FOUR - SINGLE_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR
                            + (SINGLE_INCOME_BRACKET_FIVE - SINGLE_INCOME_BRACKET_FOUR) * TAX_BRACKET_FIVE
                            + (taxableIncome - SINGLE_INCOME_BRACKET_FIVE) * TAX_BRACKET_SIX;
                }
            break;

            // Joint income calculation
            case 1:
                if (taxableIncome <= JOINT_INCOME_BRACKET_ONE) {
                    taxPayable = taxableIncome * TAX_BRACKET_ONE;
                }
                else if (taxableIncome <= JOINT_INCOME_BRACKET_TWO) {
                    taxPayable = JOINT_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (taxableIncome - JOINT_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO;
                }
                else if (taxableIncome <= JOINT_INCOME_BRACKET_THREE) {
                    taxPayable = JOINT_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (JOINT_INCOME_BRACKET_TWO - JOINT_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (taxableIncome - JOINT_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE;
                }
                else if (taxableIncome <= JOINT_INCOME_BRACKET_FOUR) {
                    taxPayable = JOINT_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (JOINT_INCOME_BRACKET_TWO - JOINT_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (JOINT_INCOME_BRACKET_THREE - JOINT_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (taxableIncome - JOINT_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR;
                }
                else if (taxableIncome <= JOINT_INCOME_BRACKET_FIVE) {
                    taxPayable = JOINT_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (JOINT_INCOME_BRACKET_TWO - JOINT_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (JOINT_INCOME_BRACKET_THREE - JOINT_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (JOINT_INCOME_BRACKET_FOUR - JOINT_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR
                            + (taxableIncome - JOINT_INCOME_BRACKET_FOUR) * TAX_BRACKET_FIVE;
                }
                else {
                    taxPayable = JOINT_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (JOINT_INCOME_BRACKET_TWO - JOINT_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (JOINT_INCOME_BRACKET_THREE - JOINT_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (JOINT_INCOME_BRACKET_FOUR - JOINT_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR
                            + (JOINT_INCOME_BRACKET_FIVE - JOINT_INCOME_BRACKET_FOUR) * TAX_BRACKET_FIVE
                            + (taxableIncome - JOINT_INCOME_BRACKET_FIVE) * TAX_BRACKET_SIX;
                }
            break;

            // Married filing separately calculation
            case 2:
                if (taxableIncome <= SEPARATE_INCOME_BRACKET_ONE) {
                    taxPayable = taxableIncome * TAX_BRACKET_ONE;
                }
                else if (taxableIncome <= SEPARATE_INCOME_BRACKET_TWO) {
                    taxPayable = SEPARATE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (taxableIncome - SEPARATE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO;
                }
                else if (taxableIncome <= SEPARATE_INCOME_BRACKET_THREE) {
                    taxPayable = SEPARATE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (SEPARATE_INCOME_BRACKET_TWO - SEPARATE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (taxableIncome - SEPARATE_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE;
                }
                else if (taxableIncome <= SEPARATE_INCOME_BRACKET_FOUR) {
                    taxPayable = SEPARATE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (SEPARATE_INCOME_BRACKET_TWO - SEPARATE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (SEPARATE_INCOME_BRACKET_THREE - SEPARATE_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (taxableIncome - SEPARATE_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR;
                }
                else if (taxableIncome <= SEPARATE_INCOME_BRACKET_FIVE) {
                    taxPayable = SEPARATE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (SEPARATE_INCOME_BRACKET_TWO - SEPARATE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (SEPARATE_INCOME_BRACKET_THREE - SEPARATE_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (SEPARATE_INCOME_BRACKET_FOUR - SEPARATE_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR
                            + (taxableIncome - SEPARATE_INCOME_BRACKET_FOUR) * TAX_BRACKET_FIVE;
                }
                else {
                    taxPayable = SEPARATE_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (SEPARATE_INCOME_BRACKET_TWO - SEPARATE_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (SEPARATE_INCOME_BRACKET_THREE - SEPARATE_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (SEPARATE_INCOME_BRACKET_FOUR - SEPARATE_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR
                            + (SEPARATE_INCOME_BRACKET_FIVE - SEPARATE_INCOME_BRACKET_FOUR) * TAX_BRACKET_FIVE
                            + (taxableIncome - SEPARATE_INCOME_BRACKET_FIVE) * TAX_BRACKET_SIX;
                }
            break;

            // Head of household calculation
            case 3:
                if (taxableIncome <= HEAD_INCOME_BRACKET_ONE) {
                    taxPayable = taxableIncome * TAX_BRACKET_ONE;
                }
                else if (taxableIncome <= HEAD_INCOME_BRACKET_TWO) {
                    taxPayable = HEAD_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (taxableIncome - HEAD_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO;
                }
                else if (taxableIncome <= HEAD_INCOME_BRACKET_THREE) {
                    taxPayable = HEAD_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (HEAD_INCOME_BRACKET_TWO - HEAD_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (taxableIncome - HEAD_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE;
                }
                else if (taxableIncome <= HEAD_INCOME_BRACKET_FOUR) {
                    taxPayable = HEAD_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (HEAD_INCOME_BRACKET_TWO - HEAD_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (HEAD_INCOME_BRACKET_THREE - HEAD_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (taxableIncome - HEAD_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR;
                }
                else if (taxableIncome <= HEAD_INCOME_BRACKET_FIVE) {
                    taxPayable = HEAD_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (HEAD_INCOME_BRACKET_TWO - HEAD_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (HEAD_INCOME_BRACKET_THREE - HEAD_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (HEAD_INCOME_BRACKET_FOUR - HEAD_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR
                            + (taxableIncome - HEAD_INCOME_BRACKET_FOUR) * TAX_BRACKET_FIVE;
                }
                else {
                    taxPayable = HEAD_INCOME_BRACKET_ONE * TAX_BRACKET_ONE
                            + (HEAD_INCOME_BRACKET_TWO - HEAD_INCOME_BRACKET_ONE) * TAX_BRACKET_TWO
                            + (HEAD_INCOME_BRACKET_THREE - HEAD_INCOME_BRACKET_TWO) * TAX_BRACKET_THREE
                            + (HEAD_INCOME_BRACKET_FOUR - HEAD_INCOME_BRACKET_THREE) * TAX_BRACKET_FOUR
                            + (HEAD_INCOME_BRACKET_FIVE - HEAD_INCOME_BRACKET_FOUR) * TAX_BRACKET_FIVE
                            + (taxableIncome - HEAD_INCOME_BRACKET_FIVE) * TAX_BRACKET_SIX;
                }
        }

        // Display results
        System.out.printf("The tax payable on $%.2f is $%.2f", taxableIncome, taxPayable);
    }

}
