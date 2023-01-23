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


    /**
     * I want to get all the filieres from the database and return them to the controller
     * 
     * @return A list of Filiere objects.
     */
    @Override
    public List<Filiere> getAll() {
        System.out.println("from getall filiere service");

        return repo.getAll();
    }

    /**
     * I want to get the code of a filiere from the database
     * 
     * @param code the code of the filiere
     * @return The code of the filiere
     */
    @Override
    public Filiere getCode(String code) {
        return repo.getCode(code);
    }
/**
 * // Java
 * 
 * @Override
 * public void add(Filiere filiere) {
 *     repo.create(filiere);
 * }
 * 
 * @param filiere the entity to be added
 */

    /**
     * The function add() is a function that is used to add a new filiere to the database
     * 
     * @param filiere the entity to be added
     */
    @Override
    public void add(Filiere filiere) {
        repo.create(filiere);
    }

    /**
     * It updates the filiere.
     * 
     * @param filiere the object to be updated
     */
    @Override
    public void update(Filiere filiere) {

        repo.update(filiere);
    }

    /**
     * The function deletes a filiere from the database
     * 
     * @param code The code of the filiere to be deleted
     */
    @Override
    public void delete(String code) {
      repo.delete(code);


    }

    @Override
    public List<Eleve> getAllEleves(Filiere filiere) {
        return repo.getAllEleves(filiere);
    }

    /**
     * It returns the number of students in a given filiere
     * 
     * @param code_fil the code of the filiere
     * @return The number of students in a filiere.
     */
    @Override
    public int getElevesCount(String code_fil) {
        return repo.getElevesCount(code_fil);
    }

   /**
    * It returns the number of students without a filiere
    * 
    * @return The number of students without a filiere.
    */
    @Override
    public int getCountElevesSansFiliere() {
        return repo.getCountElevesSansFiliere();
    }
}
