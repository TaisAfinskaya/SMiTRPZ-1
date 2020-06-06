import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister(new HashMap<>() {{
            put("product1", 100.0);
            put("product2", 180.0);
            put("product3", 17.7);
        }});
        cashRegister.addToCheck("product1", 2);
        cashRegister.addToCheck("product1", 4);
        cashRegister.addToCheck("product2", 5);
        cashRegister.addToCheck("product3", 2);
        System.out.println(cashRegister.getCheck());
    }
}
