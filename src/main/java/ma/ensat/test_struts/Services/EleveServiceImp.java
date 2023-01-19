package ma.ensat.test_struts.Services;

import ma.ensat.test_struts.Config.HibernateUtil;
import ma.ensat.test_struts.Repositories.EleveRepository;
import ma.ensat.test_struts.models.Eleve;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EleveServiceImp implements EleveService {
    List<Eleve> eleves = new ArrayList();
    static Session s;
    static Transaction Tx;
    @Autowired
    private EleveRepository repo;
    private String Eleve;

    @Override
    public List<Eleve> getAll() {
        return repo.getAll();
    }

    @Override
    public Eleve getCode(String cne) {
       return repo.getCode(cne);
    }

    @Override
    public void create(Eleve eleve) {


      repo.create(eleve);
    }

    @Override
    public void update(Eleve eleve) {

        repo.update(eleve);
    }

    @Override
    public void delete(String cne) {
       repo.delete(cne);


    }



}
