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

    /**
     * It returns a list of all the students in the database
     * 
     * @return A list of Eleve objects.
     */
    @Override
    public List<Eleve> getAll() {
        return repo.getAll();
    }

    /**
     * I want to get the code of an eleve by his cne
     * 
     * @param cne the primary key of the table
     */
    @Override
    public Eleve getCode(String cne) {
        System.out.println("from get eleve code service");

        return repo.getCode(cne);
    }

    /**
     * The function create() is a function that is part of the EleveService interface. It is
     * implemented in the EleveServiceImpl class. It takes an Eleve object as a parameter and calls the
     * create() function of the EleveRepository interface
     * 
     * @param eleve the object to be created
     */
    @Override
    public void create(Eleve eleve) {


      repo.create(eleve);
    }

    /**
     * The function update() is a function of the class EleveServiceImpl which implements the interface
     * EleveService. The function update() is used to update an existing eleve in the database
     * 
     * @param eleve the object to be updated
     */
    @Override
    public void update(Eleve eleve) {

        repo.update(eleve);
    }

    /**
     * It deletes a student from the database using the cne as a key
     * 
     * @param cne is the primary key of the table
     */
    @Override
    public void delete(String cne) {
       repo.delete(cne);


    }



}
