package ma.ensat.test_struts.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "eleves")
public class Eleve {
    public Eleve() {
    }

    @Id
    @Column(name = "cne", nullable = false)
    private String cne;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name="moyenne")
    private double moyenne;


    public Filiere getRef_fil() {
        return ref_fil;
    }

    public void setRef_fil(Filiere ref_fil) {
        this.ref_fil = ref_fil;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_fil", nullable = true)
    private Filiere ref_fil;

    public Eleve(String cne, String nom, String prenom, double moyenne) {
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

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

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
}
