package ma.ensat.test_struts.Services;

import ma.ensat.test_struts.models.Filiere;

import java.util.List;

public interface FiliereService {
    public List<Filiere> getAll();
    public Filiere getCode(int code);
    public void add(Filiere filiere);
    public void update(Filiere filiere);
    public void delete(int code);
}
