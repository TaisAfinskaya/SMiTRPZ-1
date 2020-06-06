
import java.util.HashMap;

import org.junit.*;

import static org.junit.Assert.*;

public class TestCashRegister {
    CashRegister cashRegister;

    @Before
    public void init() {
        cashRegister = new CashRegister(new HashMap<>() {{
            put("product1", 100.0);
            put("product2", 180.0);
            put("product3", 17.7);
        }});
        cashRegister.addToCheck("product1", 2);
        cashRegister.addToCheck("product1", 4);
        cashRegister.addToCheck("product2", 5);
        cashRegister.addToCheck("product3", 2);
    }

    @Test
    public void testGetGoods() {
        assertEquals("{product1=4, product2=4, product3=5}", cashRegister.getGoods().toString());
    }

    @Test
    public void testGetPrice() {

        assertEquals(Double.valueOf(100.0), cashRegister.getPrice("product1"));
        assertEquals(Double.valueOf(180.0), cashRegister.getPrice("product2"));
        assertNotEquals(17.7, cashRegister.getPrice("product2"));
    }

    @Test
    public void testGetCheck() {
        assertEquals("product3 4*17.7 = 70.8\n" +
                        "product1 4*100.0 = 400.0\n" +
                        "product2 5*180.0 = 900.0\n" +
                        "Total amount = 1370.8",
                cashRegister.getCheck());
    }
}
