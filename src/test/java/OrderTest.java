import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Smoke test confirming the JUnit 5 setup works. Real tests come later in the project. */
class OrderTest {
    @Test
    void rawSubtotalSumsLineTotals() {
        Customer c = new Customer("C1", "Test", "t@x.com", "555", "1 St", "Erie", "PA", "16501", "USA", "REGULAR");
        Order order = new Order("O1", c, 1);
        order.addItem(new OrderItem(new Item("A", "A", 10.0, 1.0, "BOOKS"), 3));
        order.addItem(new OrderItem(new Item("B", "B", 5.0, 1.0, "BOOKS"), 2));
        assertEquals(40.0, order.calculateRawSubtotal(), 0.0001);
    }
}
