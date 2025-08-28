package iut.bad;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestAll {

    @Test
    public void testConstructeur() {
        Humain humain = new Humain("Dupont", "Jean", 30);
        assertEquals("Dupont", humain.getNom());
        assertEquals("Jean", humain.getPrenom());
        assertEquals(30, humain.getAge());
    }

    @Test
    public void testToString() {
        Humain humain = new Humain("Martin", "Claire", 25);
        String attendu = "Nom: Martin, Prénom: Claire, Age: 25";
        String resultat = humain.toString();
        System.out.println(resultat);  
        assertEquals(attendu, resultat);
    }


    @Test
    public void testAmiSansErreur() {
        Humain h1 = new Humain("Alice", "Marie", 20);
        Humain h2 = new Humain("Bob", "Jhon", 22);

        
        try {
            h1.ami(h2); 
        } catch (Exception e) {
            fail("La méthode ami() a lancé une exception : " + e.getMessage());
        }
    }

    @Test
    public void testMangerEtBoire() {
        Humain humain = new Humain("Zola", "Émile", 45);

        try {
            humain.manger();
            humain.boire();
        } catch (Exception e) {
            fail("Les méthodes manger() ou boire() ont échoué : " + e.getMessage());
        }
    }
}
