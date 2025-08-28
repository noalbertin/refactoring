
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
    private MoneyBag fMB1;
    private MoneyBag fMB2;
    
    @Before
    public void setUp() {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        f21USD = new Money(21, "USD");
        
        Money bag1[] = { f12CHF, f7USD };
        fMB1 = new MoneyBag(bag1);
        
        Money bag2[] = { f14CHF, f21USD };
        fMB2 = new MoneyBag(bag2);
    }
    
    @Test
    public void testMixedSimpleAdd() {
        // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
        Money bag[] = { f12CHF, f7USD };
        MoneyBag expected = new MoneyBag(bag);
        assertEquals(expected, f12CHF.add(f7USD));
    }
    
    @Test
    public void testBagSimpleAdd() {
        // {[12 CHF][7 USD]} + [14 CHF] == {[26 CHF][7 USD]}
        Money expected[] = { new Money(26, "CHF"), f7USD };
        MoneyBag expectedBag = new MoneyBag(expected);
        assertEquals(expectedBag, fMB1.add(f14CHF));
    }
    
    @Test
    public void testSimpleBagAdd() {
        // [14 CHF] + {[12 CHF][7 USD]} == {[26 CHF][7 USD]}
        Money expected[] = { new Money(26, "CHF"), f7USD };
        MoneyBag expectedBag = new MoneyBag(expected);
        assertEquals(expectedBag, f14CHF.add(fMB1));
    }
    
    @Test
    public void testBagBagAdd() {
        // {[12 CHF][7 USD]} + {[14 CHF][21 USD]} == {[26 CHF][28 USD]}
        Money expected[] = { new Money(26, "CHF"), new Money(28, "USD") };
        MoneyBag expectedBag = new MoneyBag(expected);
        assertEquals(expectedBag, fMB1.add(fMB2));
    }
    
    @Test
    public void testSimplify() {
        // {[12 CHF][7 USD]} + [-12 CHF] == [7 USD]
        Money m = new Money(-12, "CHF");
        assertEquals(f7USD, fMB1.add(m));
    }
}