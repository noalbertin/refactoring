

import java.util.Vector;

public class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<Money>();
    
    MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
        simplify();
    }
    
    MoneyBag(Money bag[]) {
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
        simplify();
    }
    
    private IMoney appendMoney(Money m) {
        if (m.amount() == 0) 
            return m;
            
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            while ((i < fMonies.size())
                  && (!(fMonies.get(i).currency().equals(m.currency()))))
                i++;
            if (i >= fMonies.size()) {
                fMonies.add(m);
            } else {
                Money old = fMonies.get(i);
                int newAmount = old.amount() + m.amount();
                if (newAmount != 0) {
                    fMonies.set(i, new Money(newAmount, m.currency()));
                } else {
                    fMonies.remove(i);
                }
            }
        }
		return m;
    }
    
    // Simplify the MoneyBag if it contains only one currency
    private IMoney simplify() {
        if (fMonies.size() == 1) {
            return fMonies.get(0);
        }
        return this;
    }
    
    @Override
    public IMoney add(IMoney m) {
        return m.addMoneyBag(this);
    }
    
    @Override
    public IMoney addMoney(Money m) {
        MoneyBag result = new MoneyBag(new Money[0]);
        // Copy all monies from this bag
        for (Money money : fMonies) {
            result.appendMoney(money);
        }
        // Add the new money
        result.appendMoney(m);
        
        return result.simplify();
    }
    
    @Override
    public IMoney addMoneyBag(MoneyBag mb) {
        MoneyBag result = new MoneyBag(new Money[0]);
        // Copy all monies from this bag
        for (Money money : fMonies) {
            result.appendMoney(money);
        }
        // Add all monies from the other bag
        for (Money money : mb.fMonies) {
            result.appendMoney(money);
        }
        
        return result.simplify();
    }
    
    @Override
    public boolean equals(Object obj) {
        // Check if comparing to self
        if (this == obj) {
            return true;
        }
        
        // Check if obj is null
        if (obj == null) {
            return false;
        }
        
        // If obj is a Money, it can't be equal to a MoneyBag with multiple currencies
        if (obj instanceof Money) {
            return false;
        }
        
        // If obj is not a MoneyBag, it can't be equal
        if (!(obj instanceof MoneyBag)) {
            return false;
        }
        
        MoneyBag other = (MoneyBag) obj;
        
        // If sizes are different, they can't be equal
        if (fMonies.size() != other.fMonies.size()) {
            return false;
        }
        
        // For each Money in this MoneyBag, find a matching Money in the other MoneyBag
        for (Money money : fMonies) {
            boolean found = false;
            for (Money otherMoney : other.fMonies) {
                if (money.currency().equals(otherMoney.currency()) && 
                    money.amount() == otherMoney.amount()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        for (Money money : fMonies) {
            result = 31 * result + money.currency().hashCode();
            result = 31 * result + money.amount();
        }
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Money money : fMonies) {
            result.append(money.toString());
        }
        result.append("}");
        return result.toString();
    }
}