package iut.bad;

public class TestHumain {
    public static void main(String[] args) {
        Humain h1 = new Humain("Dupont", "Jean", 35);
        Humain h2 = new Humain("Martin", "Claire", 30);
        
        h1.details();
        h2.details();
        
        h1.manger();
        h2.boire();
        
        h1.ami(h2);
    }
}
