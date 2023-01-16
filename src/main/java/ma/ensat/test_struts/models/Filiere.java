package ma.ensat.test_struts.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filieres")
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_fil")
    private int code_fil;

    @Column(name = "nom_fil")
    private String nom_fil;

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    @OneToMany(mappedBy = "ref_fil", fetch = FetchType.LAZY)
    private List<Eleve> eleves;
    public Filiere() {
    }

    public Filiere(int code_fil, String nom_fil) {
        this.code_fil = code_fil;
        this.nom_fil = nom_fil;
    }

    public int getCode_fil() {
        return code_fil;
    }

    public void setCode_fil(int code_fil) {
        this.code_fil = code_fil;
    }

    public void setNom_fil(String nom_fil) {
        this.nom_fil = nom_fil;
    }

    public String getNom_fil() {
        return nom_fil;
    }
}
