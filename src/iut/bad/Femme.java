// Femme.java
package iut.bad;

public class Femme extends Humain {
    
    public Femme() {
        super();
    }
    
    public Femme(String nom, String prenom, int age) {
        super(nom, prenom, age);
    }
    
    public static void main(String[] args) {
        Homme homme = new Homme("Dupont", "Jean", 30);
        Femme femme = new Femme("Martin", "Marie", 28);
        
        femme.ami(homme);
       
    }
}