package ma.ensat.test_struts.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "filieres")
public class Filiere {

    @Id

    @Column(name = "code_fil", nullable = false)
    private String code_fil;

    @Column(name = "nom_fil")
    private String nom_fil;

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
    /*
    @OneToMany(mappedBy = "ref_fil", fetch = FetchType.LAZY,
    cascade = CascadeType.REMOVE) est une annotation utilisée pour définir une relation entre la classe Filiere et la classe Eleve.
     Cette annotation indique qu'il existe une relation de type One-to-Many entre ces deux classes,
     où une filière peut avoir plusieurs élèves mais un élève ne peut être associé qu'à une seule filière.
    L'attribut mappedBy="ref_fil" indique que la relation est définie dans la classe Eleve et
    qu'elle est mappée par l'attribut ref_fil. L'attribut fetch=FetchType.
    LAZY indique que les élèves ne seront chargés qu'au moment où ils sont utilisés pour la première fois.
   L'attribut cascade=CascadeType.REMOVE indique que si une filière est supprimée,
    tous les élèves associés à cette filière seront également supprimés mais on va s'occuper de ca apres.
     */
    @OneToMany(mappedBy = "ref_fil", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Eleve> eleves;
    public Filiere() {
    }

    public Filiere(String code_fil, String nom_fil) {
        this.code_fil = code_fil;
        this.nom_fil = nom_fil;
    }

    public String getCode_fil() {
        return code_fil;
    }

    public void setCode_fil(String code_fil) {
        this.code_fil = code_fil;
    }

    public void setNom_fil(String nom_fil) {
        this.nom_fil = nom_fil;
    }

    public String getNom_fil() {
        return nom_fil;
    }
}
