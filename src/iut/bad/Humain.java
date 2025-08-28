// Humain.java
package iut.bad;

public class Humain implements Consommation {
    protected String nom;
    protected String prenom;
    protected int age;
    
    public Humain() {
    }
    
    public Humain(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
    // Getters and setters
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void details() {
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "Nom: " + nom + ", Prénom: " + prenom + ", Age: " + age;
    }
    
    @Override
    public void manger() {
        System.out.println(prenom + " " + nom + " est en train de manger.");
    }
    
    @Override
    public void boire() {
        System.out.println(prenom + " " + nom + " est en train de boire.");
    }
    

    public void ami(Humain autre) {
        ami(autre, 100); 
    }
    
    public void ami(Humain autre, int dureeJours) {
        System.out.println(this.prenom + " " + this.nom + " est ami avec " + 
                          autre.prenom + " " + autre.nom + " depuis " + dureeJours + " jours");
    }
}