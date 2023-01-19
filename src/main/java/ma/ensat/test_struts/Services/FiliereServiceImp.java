package ma.ensat.test_struts.Services;

import ma.ensat.test_struts.Config.HibernateUtil;
import ma.ensat.test_struts.Repositories.EleveRepository;
import ma.ensat.test_struts.Repositories.FiliereRepository;
import ma.ensat.test_struts.models.Eleve;
import ma.ensat.test_struts.models.Filiere;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FiliereServiceImp implements FiliereService{
    List<Filiere> filieres = new ArrayList();
    static Session s;
    static Transaction Tx;
    @Autowired
    private FiliereRepository repo;


    @Override
    public List<Filiere> getAll() {
        System.out.println("from getall filiere service");

        return repo.getAll();
    }

    @Override
    public Filiere getCode(String code) {
        return repo.getCode(code);
    }

    @Override
    public void add(Filiere filiere) {
        repo.create(filiere);
    }

    @Override
    public void update(Filiere filiere) {

        repo.update(filiere);
    }

    @Override
    public void delete(String code) {
      repo.delete(code);


    }

    @Override
    public List<Eleve> getAllEleves(Filiere filiere) {
        return repo.getAllEleves(filiere);
    }
}
