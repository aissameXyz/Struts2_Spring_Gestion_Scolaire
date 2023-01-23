package ma.ensat.test_struts.Services;

import ma.ensat.test_struts.models.Eleve;
import ma.ensat.test_struts.models.Filiere;

import java.util.List;

public interface FiliereService {
 
    public List<Filiere> getAll();
  
    public Filiere getCode(String code);
    public void add(Filiere filiere);
    public void update(Filiere filiere);
    public void delete(String code);
    public List<Eleve> getAllEleves(Filiere filiere);
    public int getElevesCount(String code_fil);
    public int getCountElevesSansFiliere();
}
