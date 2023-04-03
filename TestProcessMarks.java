import java.util.Arrays;
import java.util.Random;

public class TestProcessMarks {
    public static void main(String[] args) {
        // Display maximum mark
        System.out.println("The maximum mark is: " + ProcessMarks.max(ProcessMarks.marksArray));

        // Display minimum mark
        System.out.println("\nThe minimum mark is: " + ProcessMarks.min(ProcessMarks.marksArray));

        // Display statistical range of marks
        System.out.println("\nThe statistical range of the marks is: "
                + ProcessMarks.range(ProcessMarks.max(ProcessMarks.marksArray),
                + ProcessMarks.min(ProcessMarks.marksArray)));

        // Display statistical mean of marks
        System.out.println("\nThe statistical mean of the marks is: " + ProcessMarks.mean(ProcessMarks.marksArray));

        // Display statistical median of sorted marks
        System.out.println("\nThe statistical median of the marks is: "
                + ProcessMarks.median(ProcessMarks.sortedMarksArray));

        // Display statistical mode of sorted marks
        System.out.println("\nThe statistical mode of the marks is: "
                + ProcessMarks.mode(ProcessMarks.sortedMarksArray));

        // Display grade of each mark according to lower boundaries
        System.out.println("\nThe graded marks are: ");
        for (int i = 0; i < ProcessMarks.marksArray.length; i++) {
            System.out.print(ProcessMarks.grades(ProcessMarks.marksArray)[i] + " ");

            // Format grades to 30 per line
            if (i % 30 == 29)
                System.out.println();
        }

        // Display statistical distribution of grades
        System.out.println("\n\nThe distribution of each mark is: ");
        for (int i = 0; i < ProcessMarks.gradesArray.length; i++) {
            System.out.println(ProcessMarks.gradesArray[i] + ": "
                    + ProcessMarks.gradeDistn(ProcessMarks.grades(ProcessMarks.marksArray))[i] + " ");
        }
    }
}

class ProcessMarks {

    // Read Marks.getMarks() array and clone contents to marksArray and sortedMarksArray
    static int[] tempArray = Marks.getMarks();
    static int[] marksArray = tempArray.clone();
    static int[] sortedMarksArray = tempArray.clone();

    // Initialise grades in array
    static char[] gradesArray = {'A', 'B', 'C', 'D', 'E', 'F'};

    // Initialise lower boundaries for grades in array ordered A, B, C, D, E
    static int[] lowerBoundaryArray = {90, 75, 60, 50, 45};

    // Create max method, return maximum grade
    public static int max(int[] marks) {

        // Initialise tempInt and maxMarks
        int tempInt = 0, maxMarks = 0;

        // Find largest value
        for (int i = 0; i < marksArray.length; i++) {
            if (tempInt < marks[i]) {
                tempInt = marks[i];
                maxMarks = tempInt;
            }
        }

        return maxMarks;
    }

    // Create min method, return minimum grade
    public static int min(int[] marks) {

        // Initialise tempInt and minMarks
        int tempInt = marks[0], minMarks = 0;

        // Find smallest value
        for (int i = 0; i < marksArray.length; i++) {
            if (tempInt > marks[i]) {
                tempInt = marks[i];
                minMarks = tempInt;
            }
        }

        return minMarks;
    }

    // Create range method, return range
    public static int range(int max, int min) {

        // Calculate range of marks and assign to marksRange
        int marksRange = max - min;
        return marksRange;
    }

    // Create mean method, return mean
    public static double mean(int[] marks) {

        // Initialise marksMean and sum variables
        int marksMean, sum = 0;

        // Sum all marks in array
        for (int i = 0; i < marksArray.length; i++) {
            sum += marks[i];
        }

        // Calculate mean
        marksMean = sum / marksArray.length;

        return marksMean;
    }

    // Create median method, return median
    public static int median(int[] marks) {

        // Initialise marksMedian and medianIndex
        int marksMedian, medianIndex;

        // Sort marks using Arrays.sort
        Arrays.sort(sortedMarksArray);

        // Find index of the median mark and assign mark to marksMedian
        if (marks.length % 2 == 0) {
            medianIndex = marks.length / 2;
            marksMedian = (sortedMarksArray[medianIndex] + sortedMarksArray[medianIndex + 1]) / 2;
        } else medianIndex = marks.length / 2;
        marksMedian = sortedMarksArray[medianIndex];

        return marksMedian;
    }

    // Create mode method, return mode
    public static int mode(int[] marks) {

        // Initialise modeMarks, maxCount, and count variables
        int modeMarks = 0, maxCount = 0;

        // Iterate over array counting occurrences in count variable
        for (int i = 0; i < marks.length; i++) {
            int count = 0;
            for (int j = 0; j < marks.length; j++) {
                if (sortedMarksArray[j] == sortedMarksArray[i]) {
                    count++;
                }
            }

            // Store max occurrence as modeMarks
            if (count > maxCount) {
                maxCount = count;
                modeMarks = sortedMarksArray[i];
            }
        }

        return modeMarks;
    }

    // Create grades method, return grades
    public static char[] grades(int[] marks) {

        // Initialise marksToGradesArray character array
        char[] marksToGradesArray = new char[marksArray.length];

        // Iterate over marks, comparing to gradesArray and marking accordingly
        for (int i = 0; i < marksArray.length; i++) {
            if (marks[i] >= lowerBoundaryArray[0]) {
                marksToGradesArray[i] = 'A';
            }
            else if (marks[i] >= lowerBoundaryArray[1]) {
                marksToGradesArray[i] = 'B';
            }
            else if (marks[i] >= lowerBoundaryArray[2]) {
                marksToGradesArray[i] = 'C';
            }
            else if (marks[i] >= lowerBoundaryArray[3]) {
                marksToGradesArray[i] = 'D';
            }
            else if (marks[i] >= lowerBoundaryArray[4]) {
                marksToGradesArray[i] = 'E';
            }
            else
                marksToGradesArray[i] = 'F';
        }

        return marksToGradesArray;
    }

    // Create gradeDistn method, return grade distribution as array
    public static int[] gradeDistn(char[] grades) {

        // Initialise gradeDistn array
        int[] gradeDistn = new int[gradesArray.length];

        // Iterate over grades, increase each grade count in gradeDistn accordingly
        for (int i = 0; i < marksArray.length; i++) {
            if (grades[i] == 'A') {
                gradeDistn[0]++;
            }
            else if (grades[i] == 'B') {
                gradeDistn[1]++;
            }
            else if (grades[i] == 'C') {
                gradeDistn[2]++;
            }
            else if (grades[i] == 'D') {
                gradeDistn[3]++;
            }
            else if (grades[i] == 'E') {
                gradeDistn[4]++;
            }
            else
                gradeDistn[5]++;
        }

        return gradeDistn;
    }
}

/**
 * A class that provides a random array of marks,
 * approximately normally distributed.
 * @author Ken Lodge
 */

class Marks {
    private static final int NMARKS = 125;
    private static final double mean = 65.0;
    private static final double std = 15.0;

    /**
     * Returns an array of NMARKS integer marks approximately normally distributed,
     * with specified mean (mean) and standard deviation (std),
     * and with values outside 0..100 removed.
     * @return the array of marks.
     */
    public static int[] getMarks() {
        Random rand = new Random(1001L);
        int mark;
        int[] theMarks = new int[NMARKS];
        int n = 0;
        while (n < NMARKS) {
            mark = (int) Math.round(std*rand.nextGaussian() + mean);
            if (mark >= 0 && mark <= 100)
                theMarks[n++] = mark;
        }
        return theMarks;
    }

    /**
     * Test code
     * @param args not used
     */
    public static void main(String[] args) {
        int[] testMarks = getMarks();
        for (int n = 0; n < testMarks.length; n++) {
            System.out.print(testMarks[n] + " ");
            if (n % 10 == 9)
                System.out.println();
        }
    }

}
