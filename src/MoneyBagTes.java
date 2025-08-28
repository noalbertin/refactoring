import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MoneyBagTes {

    private Money f12CHF, f14CHF, f7USD, f21USD;
    private MoneyBag fMB1, fMB2;

    @Before
    public void setUp() {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        f21USD = new Money(21, "USD");
        fMB1 = new MoneyBag(f12CHF, f7USD);
        fMB2 = new MoneyBag(f14CHF, f21USD);
    }

    @Test
    public void testBagEquals() {
        assertNotNull(fMB1);
        assertEquals(fMB1, fMB1);
        assertNotEquals(fMB1, f12CHF);
        assertNotEquals(f12CHF, fMB1);
        assertNotEquals(fMB1, fMB2);
    }
}
