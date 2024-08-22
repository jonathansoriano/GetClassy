import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product pr1, pr2, pr3;

    @BeforeEach
    void setUp() {
        pr1 = new Product("Dog Treats","Fancy Bones", 35.50);
        pr2 = new Product("Cat Treats", "Cat Nip", 25.75);
        pr3 = new Product("Bird Treats", "Grass Seed", 15.25);

    }

    @Test
    void setName() {
        pr1.setName("Dawg Treats");
        assertEquals("Dawg Treats", pr1.getName());
    }

    @Test
    void setDescription() {
        pr2.setDescription("Meow Meow Weed");
        assertEquals("Meow Meow Weed", pr2.getDescription());
    }

    @Test
    void setCost() {
        pr3.setCost(1.50);
        assertEquals(1.50, pr3.getCost());
    }

    @Test
    void fullDescription() {
        assertEquals("Dog Treats - Fancy Bones", pr1.fullDescription());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001,Dog Treats,Fancy Bones,35.5", pr1.toCSVDataRecord());
    }

    @Test
    void testToString() {
        assertEquals("Product{ID='000001', name='Dog Treats', description='Fancy Bones', cost=35.5}", pr1.toString());
    }
}