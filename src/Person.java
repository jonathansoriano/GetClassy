import java.util.Calendar;
import java.util.Objects;

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

    /**
     * This is a method that retrieves the ID of an object of the Person class.
     * @return - returns a String number ID.
     */
    //Getter and Setter Methods for ID
    public String getID(){
        return ID;
    }

    /**
     * This method allows you to change the ID of an object of the Person class.
     * @param ID - You have to enter a String number for what you want the new ID as a
     */
    public void setID(String ID){ // I don't think we need this since we want the computer to auto assign IDs
        // and the String ID should "never change sequence of digits".
        this.ID = ID;
    }

    /**
     * This method auto increments and auto assigns a 6-digit ID number for an object of the Person class.
     * @return - returns a 6-digit String number
     */
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

    /**
     * This is a method that retrieves the first name of an object of the Person class.
     * @return - returns the first name of the Person object.
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * This methods allows you to change the first name of the object of the Person class.
     * @param firstName - You need to enter a first name type String to change the name.
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //Getter and Setter Methods for lastName

    /**
     * This method retrieves the lastname of an object of the Person class.
     * @return - returns the last name of the Person object.
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * This method allows you to change the lastname of the Person object.
     * @param lastName - you need a lastname type String to change the lastname.
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //Getter and Setter Methods for title

    /**
     * This method retrieves the title of a Person object.
     * @return - Returns the title type String of the Person object.
     */
    public String getTitle(){
        return title;
    }

    /**
     * This methods allows you to change the title of the Person object.
     * @param title - you need to enter a title type String to change the title.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    //Getter and Setter Methods for yob

    /**
     * This method retrieves the year of birth of a Person object.
     * @return - returns a YOB type int.
     */
    public int getYOB(){
        return yob;
    }

    /**
     * This method allows you to change the YOB of a Person object.
     * @param yob - you need to enter a number type int to change the yob.
     */
    public void setYOB(int yob){
        this.yob = yob;
    }
    // Additional Methods

    /**
     * This method combines and returns the first and last name of type String for a Person object.
     * @return - returns first and last name of a Person object.
     */
    public String fullName(){ // METHOD TO GET FULL NAME
        return firstName + " " + lastName;
    }

    /**
     * This method includes the title of the person proceeded by the first and last name of a Person object.
     * @return - returns the title, first name , and last name of type String of a Person object.
     */
    public String getFormalName(){ // METHOD TO GET FORMAL NAME
        return title + " " + fullName();
    }

    /**
     * This method calculates the age of person but the current year is hardcoded to find age.
     * @return - returns an age type int of the Person object.
     */
    public String getAge(){ // Hard coded the year to find age for this version of the method getAge.
        int age = 2024 - yob;
        String value = Integer.toString(age); // Integer.toString(age); converts int's to String.

        return value;
    }

    /**
     * This method finds the age of the person at any given "year" using their yob.
     * @param year - User enters a year type int that will return the
     *             age of that specific year.
     * @return - returns an age type int of the Person object. If age is 0, then it prints out they aren't born yet.
     */
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

    /**
     * This method takes the data fields of the Person object and formats them in CSV format for a text file
     * @return - returns a CSV formatted text file of the person's data fields.
     */
    public String toCSVDataRecord(){ //METHOD TO WRITE A STRING THAT CAN BE USED TO WRITE INTO A CSV FILE
        String personRecord = "";

        personRecord = getID() + "," + getFirstName() + "," + getLastName() + "," + getTitle() + "," + getYOB();
        //When you concat an integer type,(getYOB) it converts it into a String.

        return personRecord;
    }

    /**
     * This method takes the data fields of the Person object and formats them in JSON format for a text file
     * @return - returns a JSON formatted text file of the person's data fields.
     */
    public String toJSONRecord(){
        String personRecord = "";
        char DQ = '\u0022'; // This is the equivalent of double quotes but in character form.
                            // Makes it easier to code and read the toJSONRecord method.

        personRecord = "{" + DQ + "IDNum" + DQ + ":" + DQ + getID() + DQ + "," + DQ + "firstName" + DQ + ":" + DQ + getFirstName() + DQ + ","
                            + DQ + "lastName" + DQ + ":" + DQ + getLastName() + DQ + "," + DQ + "title" + DQ + ":" + DQ + getTitle() + DQ + ","
                            + DQ + "YOB" + DQ + ":" + DQ + getYOB() + DQ + "}";

        return personRecord;

    }

    /**
     * This method takes the data fields of the Person object and formats them in XML format for a text file
     * @return - returns a XML formatted text file of a person's data fields.
     */
    public String toXMLRecord(){
        String personRecord = "";
        personRecord = "<Person>";
        personRecord += "<IDNum>" + getID() + "</IDNum>";
        personRecord += "<firstName>" + getFirstName() + "</firstName>";
        personRecord += "<lastName>" + getLastName() + "</lastName>";
        personRecord += "<title>" + getTitle() + "</title>";
        personRecord += "<YOB>" + getYOB() + "</YOB>";
        personRecord += "</Person>";

        return personRecord;
    }

    /**
     * This method allows us to print out our data fields of a Person object into an organized String format.
     * @return - print out our data fields of a Person object into an organized String format.
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return yob == person.yob && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, yob);
    }
}
