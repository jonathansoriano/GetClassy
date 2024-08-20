import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    private static ArrayList<Person> folks = new ArrayList<>();// List to store all Person objects (used to save fields of Person objects.)

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); // Scanner is necessary to get input from user
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;
        String nameOfFile = "";
        boolean done = false; // Needed to repeat or end loop.

        do {
            // Due to the update "Person" constructor, we don't need to assign an ID; bc the constructor has a method
            // that generates sequential number ID. (generateID();)
            firstName = SafeInput.getNonZeroLenString(in, "Enter the firstname ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the lastname ");
            title = SafeInput.getNonZeroLenString(in, "Enter the title ");
            yearOfBirth = SafeInput.getRangedInt(in, "Enter the year of birth ", 1940, 2000); // Need at least 4 digits for YOB

            Person person = new Person(firstName, lastName, title, yearOfBirth); // We instantiate person object here and
            // and put in variables to the parameters
            // that match the correct data type.


            folks.add(person);

            done = SafeInput.getYNConfirm(in, "Are you done? "); // Asking if we are done adding people's info to ArrayList
        }while(!done);

        /* for (int i = 0; i < folks.size(); i++) // This is the regular for loop. Starts with 0 index and since it's a List
                                                 // we do ".size()" method instead of ".length()".
            System.out.println(folks.get(i)); // Printing out all the values in ArrayList
        */


        // Traverses the people ArrayList
        System.out.println("\nObjects written:");
        for (Person p : folks) { // For Each Loop. Use Person as the type since our Array is type Person
            System.out.println(p); // p represents item in the "folks" ArrayList. Uses toString(); to print our the objects
            // with all its data.
        }



        try
        {
            nameOfFile = SafeInput.getNonZeroLenString(in, "Enter the name of your file ");
            createFile(nameOfFile);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    } // End of main Method

    /*private static void createFile(String filename) throws IOException {
        FileWriter myWriter = new FileWriter(filename + ".txt");

        for(Person line : folks){ // Don't fully understand what is happening here but got it from CP1 homework.
            myWriter.write(line + "\n");
        }
        myWriter.close();
        System.out.println("Created and wrote to the file!");
    } */


    /**
     * Converts the attributes assigned to the "Person" object to a readable CSV file.
     * DOESN'T use the toString text to convert to CSV file, only attributes from the object.
     * @param filename - uses the input of user to name the file.
     * @throws IOException - throws exceptions that might be thrown due to it being a file.
     */
    private static void createFile(String filename) throws IOException {
        try (FileWriter myWriter = new FileWriter(filename + ".txt")) {
            for (Person person : folks) { //Type Person, "person" is what is being printed out. It's just a variable.
                // Folks is the name of the ArrayList we are looping in.
                myWriter.write(person.toCSVDataRecord() + "\n");
            }
        }
        System.out.println("Created and wrote to the file!");
    }
}
