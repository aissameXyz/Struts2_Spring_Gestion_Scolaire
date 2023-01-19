package ma.ensat.test_struts.Repositories;

import ma.ensat.test_struts.models.Eleve;
import ma.ensat.test_struts.models.Filiere;

import java.util.List;

public interface FiliereRepository {
    List<Filiere> getAll();
    Filiere getCode(String id);
    void create(Filiere type);
    void update(Filiere type);
    void delete(String id);
    public List<Eleve> getAllEleves(Filiere filiere);
}
