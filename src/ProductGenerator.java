import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    private static ArrayList<Product> products = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Scanner is necessary to get input from user.
        String ID = "";
        String name = "";
        String description = "";
        double cost = 0.0;
        String nameOfFile = "";
        boolean done = false; // Needed to repeat or end loop.

        while(!done){
            name = SafeInput.getNonZeroLenString(in, "Enter a name ");
            description = SafeInput.getNonZeroLenString(in, "Enter a description of the item ");
            cost = SafeInput.getDouble(in, "Enter the cost of the item ");

            Product items = new Product(name, description, cost);

            products.add(items);

            done = SafeInput.getYNConfirm(in, "Are you done? ");
        }

        for (Product i : products){
            System.out.println(i);
        }
        nameOfFile = SafeInput.getNonZeroLenString(in, "Enter the name of your file ");

        try
        {

            createFile(nameOfFile);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }







    } // End of main Method
    /**
     * Converts the attributes assigned to the "Person" object to a readable CSV file.
     * DOESN'T use the toString text to convert to CSV file, only attributes from the object.
     * @param filename - uses the input of user to name the file.
     * @throws IOException - throws exceptions that might be thrown due to it being a file.
     */
    private static void createFile(String filename) throws IOException {
        try (FileWriter myWriter = new FileWriter(filename + ".txt")) {
            for (Product i : products) { //Type Product, "i" is what is being printed out. It's just a variable.
                // "products" is the name of the ArrayList we are looping in.
                myWriter.write(i.toCSVDataRecord() + "\n");
            }
        }
        System.out.println("Created and wrote to the file!");
    }
}
