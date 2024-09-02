import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// To create a "Tests" directory, you need to right-click on the project folder, and press "New"
// and click Directory and name it. Once it's made, you need to right-click the new directory and do down to "Mark Directory as"
// and choose the option to "Tests Sources Root". Now all of your Tests will pop in the "Tests" file/directory.

class PersonTest {
    Person p1, p2, p3; // We need to instantiate objects of the Person class
    @BeforeEach
    void setUp() { // Here are going to enter the fields of the "Person" Constructor
        p1 = new Person("000001", "Jon", "Sanjuan", "Mr.", 2000); //Each variable is a unique instance of the Person class
        p2 = new Person("000002", "Gigo", "Soriano", "Mr.", 2003);
        p3 = new Person("000003", "Pedro", "Sanjuan", "Mr.", 2005);
    }

    @Test
    void setID() { // Passed Test
        p1.setID("00000A"); // Syntax to run test include using the method and using the "assertEquals" method to make sure our method works.
        assertEquals("00000A", p1.getID());
    }

    @Test
    void setFirstName() { // Passed Test
        p1.setFirstName("Big Brother Jon");
        assertEquals("Big Brother Jon", p1.getFirstName());
    }

    @Test
    void setLastName() { // Passed Test
        p1.setLastName("Soriano");
        assertEquals("Soriano", p1.getLastName());

    }

    @Test
    void setTitle() { // Passed Test
        p1.setTitle("Sir.");
        assertEquals("Sir.", p1.getTitle());
    }

    @Test
    void setYOB() { // Passed Test
        p1.setYOB(1999); // Remember, YOB is an int so no need to use double quotes.
        assertEquals(1999, p1.getYOB());
    }

    @Test
    void fullName() { // Passed Test
        assertEquals("Jon Sanjuan", p1.fullName());
    }

    @Test
    void getFormalName() { // Passed Test
        assertEquals("Mr. Jon Sanjuan", p1.getFormalName());
    }

    @Test
    void getAge() { // Passed Test
        assertEquals("24", p1.getAge());
    }

    @Test
    void getAgeWithParameters() { // To avoid issues with method overloading while testing, we can't have two of the
        // same test names in JUNIT. Changing test name won't affect the method we are trying to test.
        // Passed Test
        assertEquals("16", p1.getAge(2016));
    }

    @Test
    void toCSVDataRecord() { // Passed Test
        assertEquals("000001,Jon,Sanjuan,Mr.,2000", p1.toCSVDataRecord());
    }

    @Test
    void toJSONRecord(){
        assertEquals("{\"IDNum\":\"000001\",\"firstName\":\"Jon\",\"lastName\":\"Sanjuan\",\"title\":\"Mr.\",\"YOB\":\"2000\"}", p1.toJSONRecord());
    }

    @Test
    void toXMLRecord(){
        assertEquals("<Person><IDNum>000001</IDNum><firstName>Jon</firstName><lastName>Sanjuan</lastName><title>Mr.</title><YOB>2000</YOB></Person>", p1.toXMLRecord());
    }

    @Test
    void toStringMethod() {
        assertEquals("Person{ID='000001', firstName='Jon', lastName='Sanjuan', title='Mr.', yob=2000}", p1.toString());
    }


    //Still need to test generateID method? Ask the Professor Since the Method is private.
}