public class ObjInputTest {
    public static void main(String[] args) {

        SafeInputObj obj = new SafeInputObj();
        String fName = "";
        String pattern = "";
        int randomInt = 0;
        int randomInt2 = 0;
        double randomDouble = 0.0;
        double randomDouble2 = 0.0;
        boolean done = false;

        while(!done){
            fName = obj.getNonZeroLenString("What is your name");
            randomInt = obj.getRangedInt("Please enter a number between", 0, 100);
            randomInt2 = obj.getInt("Enter a random number");
            randomDouble = obj.getRangedDouble("Please enter a double between", 1.0, 100.0);
            randomDouble2 = obj.getDouble("Enter a random double");
            pattern = obj.getRegExString("Please select an option [A,S,D]", "[AaSsDd]");
            done = obj.getYNConfirm("Are you done");
        }





        System.out.println("This is your name " + fName);
        System.out.println("This is your ranged int: " + randomInt);
        System.out.println("This is your random int: " + randomInt2);
        System.out.println("This is your ranged double: " + randomDouble);
        System.out.println("This is your random double: " + randomDouble2);
        System.out.println("This is your option: " + pattern);
        System.out.println("You said you were done.");



    }
}