import java.util.ArrayList;

public class TestTextbook {
    public static void main(String[] args) {

        // Create ArrayList to hold textbook objects
        ArrayList<Textbook> textbooksArrayList = new ArrayList<>();

        // New Python textbook using default no-arg constructor
        ProgrammingTextbook newPython = new ProgrammingTextbook();
        newPython.setProgrammingLanguage("Python");
        newPython.setTitle("Programming in Python");
        newPython.setAuthor("Guido van Rossum");
        newPython.setPages(256);

        // Add the new textbook to the ArrayList
        textbooksArrayList.add(newPython);

        // New Python textbook 2
        ProgrammingTextbook newPython2 = new ProgrammingTextbook("Python");
        newPython2.setTitle("Programming in Python 2");
        newPython2.setAuthor("Guido van Rossum");
        newPython2.setPages(512);

        // Add the new textbook to the ArrayList
        textbooksArrayList.add(newPython2);

        // New Java textbook
        ProgrammingTextbook newJava = new ProgrammingTextbook("Java");
        newJava.setTitle("Programming in Java");
        newJava.setAuthor("James Gosling");
        newJava.setPages(256);

        // Add the new textbook to the ArrayList
        textbooksArrayList.add(newJava);

        // New Java textbook 2
        ProgrammingTextbook newJava2 = new ProgrammingTextbook("Java");
        newJava2.setTitle("Programming in Java 2");
        newJava2.setAuthor("James Gosling");
        newJava2.setPages(512);

        // Add the new textbook to the ArrayList
        textbooksArrayList.add(newJava2);

        // New electrical engineering textbook using default no-arg constructor
        EngineeringTextbook newElectrical = new EngineeringTextbook();
        newElectrical.setEngineeringField("Electrical Engineering");
        newElectrical.setTitle("Electrical Engineering for Dummies");
        newElectrical.setAuthor("Nikola Tesla");
        newElectrical.setPages(240);

        // Add the new textbook to the ArrayList
        textbooksArrayList.add(newElectrical);

        // New mechatronic engineering textbook
        EngineeringTextbook newMechatronic = new EngineeringTextbook("Mechatronic Engineering");
        newMechatronic.setTitle("Mechatronic Engineering for Dummies");
        newMechatronic.setAuthor("Isaac Asimov");
        newMechatronic.setPages(300);

        // Add the new textbook to the ArrayList
        textbooksArrayList.add(newMechatronic);

        // New software engineering textbook
        EngineeringTextbook newSoftware = new EngineeringTextbook("Software Engineering");
        newSoftware.setTitle("Software Engineering for Dummies");
        newSoftware.setAuthor("Alan Turing");
        newSoftware.setPages(256);

        // Add the new textbook to the ArrayList
        textbooksArrayList.add(newSoftware);

        // New chemical engineering textbook
        EngineeringTextbook newChemical = new EngineeringTextbook("Chemical Engineering");
        newChemical.setTitle("Chemical Engineering for Dummies");
        newChemical.setAuthor("Amedeo Avogadro");
        newChemical.setPages(440);

        // Add the new textbook to the ArrayList
        textbooksArrayList.add(newChemical);

        // Display textbook details
        System.out.println("List of current textbooks: ");
        for (int i = 0; i < textbooksArrayList.size(); i++) {
            System.out.println(textbooksArrayList.get(i));
        }
    }
}

abstract class Textbook {

    // Title, author and pages fields
    protected String title;
    protected String author;
    protected int pages;

    // No-arg constructor
    protected Textbook() {
    }

    // Set title
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    // Set author
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    // Set pages
    public void setPages(int newPages) {
        this.pages = newPages;
    }

    // Get title
    public abstract String getTitle();

    // Get author
    public abstract String getAuthor();

    // Get pages
    public abstract int getPages();

    // Modify toString method to display textbook information
    public String toString() {
        return "\nTitle: " + getTitle() + "\nAuthor: " + getAuthor() + "\nPages: " + getPages();
    }
}

class ProgrammingTextbook extends Textbook {

    // Programming language data field
    private String programmingLanguage;

    // No-arg constructor
    public ProgrammingTextbook() {
        super();
    }

    // Get title
    public String getTitle() {
        return title;
    }

    // Get author
    public String getAuthor() {
        return author;
    }

    // Get pages
    public int getPages() {
        return pages;
    }

    // Construct programming textbook object with specified programming language
    public ProgrammingTextbook(String programmingLanguage) {
        super();
        this.programmingLanguage = programmingLanguage;
    }

    // Set programming language
    public void setProgrammingLanguage(String newProgrammingLanguage) {
        this.programmingLanguage = newProgrammingLanguage;
    }

    // Get programming language
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    // Modify toString method to display programming textbook information
    public String toString() {
        return "\nProgramming Textbook, Language: " + getProgrammingLanguage() + super.toString();
    }
}

class EngineeringTextbook extends Textbook {

    // Engineering field data field
    private String engineeringField;

    // No-arg constructor
    public EngineeringTextbook() {
        super();
    }

    // Get title
    public String getTitle() {
        return title;
    }

    // Get author
    public String getAuthor() {
        return author;
    }

    // Get pages
    public int getPages() {
        return pages;
    }

    // Construct engineering textbook with specified engineering field
    public EngineeringTextbook(String engineeringField) {
        super();
        this.engineeringField = engineeringField;
    }

    // Set engineering field
    public void setEngineeringField(String newEngineeringField) {
        this.engineeringField = newEngineeringField;
    }

    // Get engineering field
    public String getEngineeringField() {
        return engineeringField;
    }

    // Modify toString method to display engineering textbook information
    public String toString() {
        return "\nEngineering Textbook, Field: " + getEngineeringField() + super.toString();
    }
}
