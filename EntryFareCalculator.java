import java.util.Scanner;

public class EntryFareCalculator {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare entry prices
        final int ACCOMPANIED_CHILD = 2;
        final int UNACCOMPANIED_CHILD = 5;
        final int ADULT = 10;
        final int SENIOR = 8;

        // Initialise total takings variable
        int totalTakings = 0;

        // Prompt user to enter a selection
        System.out.print("Enter a group? Yes (1) or No (0): ");
        int enterGroup = input.nextInt();

        // Continue program until user terminates
        while (enterGroup == 1) {

            // Prompt user for number of entrants
            System.out.print("Enter the number of children (age 6-15): ");
            int numberOfChildren = input.nextInt();
            System.out.print("Enter the number of adults (age 16-59): ");
            int numberOfAdults = input.nextInt();
            System.out.print("Enter the number of seniors (age 60+): ");
            int numberOfSeniors = input.nextInt();

            // Distinguish unaccompanied children from total number of children
            int unaccompaniedChildren = numberOfChildren - (numberOfAdults + numberOfSeniors);
            if (unaccompaniedChildren < 0)
                unaccompaniedChildren = 0;

            // Calculate total charge
            int accompaniedChildrenCharge = (numberOfChildren - unaccompaniedChildren) * ACCOMPANIED_CHILD;
            int unaccompaniedChildrenCharge = unaccompaniedChildren * UNACCOMPANIED_CHILD;
            int adultCharge = numberOfAdults * ADULT;
            int seniorCharge = numberOfSeniors * SENIOR;
            int totalCharge = accompaniedChildrenCharge + unaccompaniedChildrenCharge + adultCharge + seniorCharge;

            // Calculate daily takings
            totalTakings += totalCharge;

            // Reset variables
            numberOfChildren = 0;
            numberOfAdults = 0;
            numberOfSeniors = 0;
            unaccompaniedChildren = 0;

            // Display charge for each group
            System.out.println("Total entry charge is: $" + totalCharge + "\n");

            // Continue adding groups or exit
            System.out.print("Enter a group? Yes (1) or No (0): ");
            enterGroup = input.nextInt();
        }

        // Display total takings
        System.out.println("Total takings: $" + totalTakings);
    }
}
