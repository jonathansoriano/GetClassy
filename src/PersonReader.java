import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    private static ArrayList<Person> folks = new ArrayList<>();
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>(); // this array list just read the records of the file
        // with the files original CSV format

        final int FIELDS_LENGTH = 5;

        String id, firstName, lastName, title; // Declaring variables.
        int yob;

        File workingDirectory = new File(System.getProperty("user.dir")); // Can this be outside the try block
        chooser.setCurrentDirectory(workingDirectory);

        try
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath(); //Converting file "selectedFile" to Path?
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                // Finally, we can read the file LOL!
                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);  // read all the lines into memory in an array list

                    // echo to screen

                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");

                // Now process the lines in the arrayList
                // Split the line into the fields by using split with a comma
                // use trim to remove leading and trailing spaces
                // Numbers need to be converted back to numeric values. Here only
                // the last field year of birth yob is an int the rest are strings.

                // Placed columns outside for loop, so it doesn't get printed multiple times.
                System.out.printf("\n%-8s%-25s%-25s%-6s%6s", "ID#", "First Name", "Lastname", "Title", "YOB"); // Formated Columns
                System.out.printf("\n======================================================================"); // Bracket?

                String[] fields;
                for(String l:lines) // This read the records of the file one by one.
                {
                    fields = l.split(","); // Every comma the file/ArrayList (lines) has it deletes it
                    // Splits the record into the fields


                    if(fields.length == FIELDS_LENGTH)
                    {
                        id        = fields[0].trim();
                        firstName = fields[1].trim();
                        lastName  = fields[2].trim();
                        title     = fields[3].trim();
                        yob       = Integer.parseInt(fields[4].trim()); // Turns yob back into an int.


                        Person person = new Person(id, firstName, lastName, title, yob); // we use the data from the "FIELDS"
                        // to instantiate a Person object

                        folks.add(person); // we will add every person object into the folks ArrayList.



                    }
                    else
                    {
                        System.out.println("\nFound a record that may be corrupt: ");
                        System.out.println(l);
                    }
                }


                for (Person p: folks){ // For loop to print out the ArrayList (One full record at a time) and it's formatted.
                    System.out.printf("\n%-8s%-25s%-25s%-6s%6d", p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB());
                }



            }
            else  // user closed the file dialog without choosing
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }  // end of TRY
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}
