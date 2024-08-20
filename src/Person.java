import java.util.Calendar;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int yob;

    private static int IDSeed = 1; // variable that starts the first value of our ID number when assigned and generated.
                            // used in method generateID() below.

    // To understand why we used "this.set(nameofMethod)" in our constructor, look at your Encapsulation Project on your computer.
    public Person (String ID, String firstName, String lastName, String title, int yob){
        this.setID(ID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTitle(title);
        this.setYOB(yob);
    }

    public Person (String firstName, String lastName, String title, int yob){ //UPDATED CONSTRUCTOR USE THIS
        this.ID = generateID(); // We assign whatever is returned from "generateID()" which returns newID, to ID. This is how we get the ID.
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTitle(title);
        this.setYOB(yob);
    }
    //Getter and Setter Methods for ID
    public String getID(){
        return ID;
    }
    public void setID(String ID){ // I don't think we need this since we want the computer to auto assign IDs
        // and the String ID should "never change sequence of digits".
        this.ID = ID;
    }

    private String generateID(){ // PRIVATE METHOD, SO IT MEANS IT'S ONLY USED WITHIN THIS CLASS
        String newID = "" + IDSeed;

        while(newID.length() < 6){ // Syntax doesn't match a normal logical expression. Will print out 6 chars, not 5.(As per Perplexity)
            // Ex. (int x = 1; x < 6; x++)
            // In a for loop it would print up to 5 due to it being a logical expression, but here this is
            // just how it works.
            newID = "0" + newID;
            // to get 6 chars, it will add zeros to the number on top of the newID number(s).
        }
        IDSeed ++; // increments the ID number after every use of the method.
        return newID;
    }


    //Getter and Setter Methods for firstName
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //Getter and Setter Methods for lastName
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //Getter and Setter Methods for title
    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    //Getter and Setter Methods for yob
    public int getYOB(){
        return yob;
    }
    public void setYOB(int yob){
        this.yob = yob;
    }
    // Additional Methods
    public String fullName(){ // METHOD TO GET FULL NAME
        return firstName + " " + lastName;
    }
    public String getFormalName(){ // METHOD TO GET FORMAL NAME
        return title + " " + fullName();
    }
    public String getAge(){ // Hard coded the year to find age for this version of the method getAge.
        int age = 2024 - yob;
        String value = Integer.toString(age); // Integer.toString(age); converts int's to String.

        return value;
    }

    public String getAge(int year){ //This method finds the age of the person at any given
        // "year" using their yob.
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);

        int specifiedYear = cal.get(Calendar.YEAR);

        int age = specifiedYear - this.yob;

        if (age < 0) {
            return "Not born yet";
        } else {
            return String.valueOf(age);
        }
    }

    public String toCSVDataRecord(){ //METHOD TO WRITE A STRING THAT CAN BE USED TO WRITE INTO A CSV FILE
        String personRecord = "";

        personRecord = getID() + "," + getFirstName() + "," + getLastName() + "," + getTitle() + "," + getYOB();
        //When you concat an integer type,(getYOB) it converts it into a String.

        return personRecord;
    }

    @Override // Means we made our own version of the toString method.
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", yob=" + yob +
                '}';
    }
}
