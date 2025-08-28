

public class Money implements IMoney {
    private int fAmount;
    private String fCurrency;
    
    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }
    
    public int amount() {
        return fAmount;
    }
    
    public String currency() {
        return fCurrency;
    }
    
    @Override
    public IMoney add(IMoney m) {
        return m.addMoney(this);
    }
    
    @Override
    public IMoney addMoney(Money m) {
        if (currency().equals(m.currency())) {
            return new Money(amount() + m.amount(), currency());
        }
        return new MoneyBag(this, m);
    }
    
    @Override
    public IMoney addMoneyBag(MoneyBag mb) {
        return mb.addMoney(this);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Money)) return false;
        
        Money other = (Money) obj;
        return amount() == other.amount() && currency().equals(other.currency());
    }
    
    @Override
    public int hashCode() {
        return fAmount + fCurrency.hashCode();
    }
    
    @Override
    public String toString() {
        return "[" + amount() + " " + currency() + "]";
    }
}