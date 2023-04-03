import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSubject {
    public static void main(String[] args) throws IOException {

        // Create scanner object for user input, use delimiter take whole input including whitespace
        Scanner inputKey = new Scanner(System.in).useDelimiter("\n");

        // Create no arg Subject object
        Subject newSubject = new Subject();

        // Create ArrayList to hold subject details objects
        ArrayList<Subject> subjectDetailsArrayList = new ArrayList<>();

        // Define file location
        String subjectsFileLocation = "D:\\Desktop\\Uni Stuff\\Bachelor of Science\\ITC206 - Programming in Java 1"
                + "\\Assessment 3\\Subjects.txt";
        File subjectsFile = new File(subjectsFileLocation);

        // Check file for readability
        if (subjectsFile.canRead()) {

            // Create scanner object
            Scanner inputFile = new Scanner(subjectsFile);

            // Create temporary array for individual subject details
            String[] temp;

            // Iterate over lines in file
            while (inputFile.hasNextLine()) {

                // Store each line in temporary array
                temp = inputFile.nextLine().split(": ", 2);

                // Create a new subject object from the temporary array and store in the ArrayList
                subjectDetailsArrayList.add(new Subject(temp[0], temp[1]));
            }

            // Close file
            inputFile.close();
        }

        // Display existing subjects
        System.out.println("Current subjects: ");
        for (int i = 0; i < subjectDetailsArrayList.size(); i++) {
            System.out.println(subjectDetailsArrayList.get(i));
        }

        // Prompt for new subjects until exit by user
        String newSubjectCode;
        String newSubjectName;

        // Display message for prompt
        System.out.print("Enter a new code or Q to exit: ");

        // Take user input, continue taking input until sentinel value is entered
        newSubjectCode = inputKey.next();
        while (newSubjectCode.equalsIgnoreCase("Q") == false) {

            // Test validity of subject code
            if (newSubject.isValidCode(newSubjectCode)) {

                // Check if subject code already exists in subject list
                if (newSubject.codeExists(newSubjectCode, subjectDetailsArrayList)) {
                    System.out.println("Code already exists.");
                }
                // If code does not exist, prompt for subject name and add new subject to list
                else {
                    System.out.print("Enter subject name: ");
                    newSubjectName = inputKey.next();
                    subjectDetailsArrayList.add(new Subject(newSubjectCode, newSubjectName));
                }
            }
            else {
                System.out.println("Code is invalid");
            }
            System.out.print("Enter a new code or Q to exit: ");
            newSubjectCode = inputKey.next();
        }
        // Display existing subjects
        System.out.println("Current subjects: ");
        for (int i = 0; i < subjectDetailsArrayList.size(); i++) {
            System.out.println(subjectDetailsArrayList.get(i));
        }

        // Write subjectDetailsArrayList to file
        if (subjectsFile.canWrite()) {

            // Create PrintWriter object
            PrintWriter outputFile = new PrintWriter(subjectsFile);

            // Iterate over list of subjects and print to file
            for (int i = 0; i < subjectDetailsArrayList.size(); i++) {
                outputFile.println(subjectDetailsArrayList.get(i));
            }
            // Close file
            outputFile.close();
        }
    }
}
class Subject {

    // Subject name and code fields
    private String subjectName;
    private String subjectCode;

    // No-arg constructor
    Subject() {
    }

    // Construct subject object with specified name and code
    Subject(String subjectCode, String subjectName) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    // Set subject code
    public void setSubjectCode(String newSubjectCode) {
        this.subjectCode = newSubjectCode;
    }

    // Set subject name
    public void setSubjectName(String newSubjectName) {
        this.subjectName = newSubjectName;
    }

    // Get subject code
    public String getSubjectCode() {
        return subjectCode;
    }

    // Get subject name
    public String getSubjectName() {
        return subjectName;
    }

    // Determine if subject code matches the argument provided
    public boolean codeMatches(String newSubjectCode, String existingSubjectCode) {

        // Initialise codeMatches boolean
        boolean codeMatches = false;

        // Check if new subject code matches an existing code
        if (existingSubjectCode.matches("(.*)" + newSubjectCode + "(.*)")) {
            codeMatches = true;
        }
        return codeMatches;
    }

    public boolean codeExists(String newSubjectCode, ArrayList subjectDetailsArrayList) {

        // Initialise codeExists boolean
        boolean codeExists = false;

        // Check if subject details ArrayList contains new subject code from user input
        for (int i = 0; i < subjectDetailsArrayList.size(); i++) {
            if (this.codeMatches(newSubjectCode, subjectDetailsArrayList.get(i).toString())) {
                codeExists = true;
            }
        }

        return codeExists;
    }

    // Determine if subject code satisfies requirements
    public boolean isValidCode(String subjectCode) {

        // Initialise validCode boolean, and alphabetical/numerical regex expressions to check subject code by parts
        boolean validCode;
        String regexAlpha = "^[a-zA-Z]+$";
        String regexNumeric = "^[0-9]+$";

        // Determine if code meets length requirement
        if (subjectCode.length() == 6) {

            // Split subject code into parts
            String subjectCodeAlpha = subjectCode.substring(0, 3);
            String subjectCodeNumeric = subjectCode.substring(3, 6);

            // Validate by parts for correct character formatting
            if (subjectCodeAlpha.matches(regexAlpha) && subjectCodeNumeric.matches(regexNumeric)) {
                validCode = true;
            }
            else {
                validCode = false;
            }
        }
        else {
            validCode = false;
        }
        return validCode;
    }

    // Modify toString method to display subject details
    public String toString() {
        return getSubjectCode() + ": " + getSubjectName();
    }
}