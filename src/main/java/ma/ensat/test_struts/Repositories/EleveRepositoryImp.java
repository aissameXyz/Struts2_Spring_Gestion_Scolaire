package ma.ensat.test_struts.Repositories;

import ma.ensat.test_struts.Config.HibernateUtil;
import ma.ensat.test_struts.models.Eleve;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EleveRepositoryImp implements EleveRepository{
    static Session s;
    static Transaction Tx;
   /**
    * I'm trying to get all the data from the table Eleve and put it in a list
    * 
    * @return A list of Eleve objects.
    */
    @Override
    public List<Eleve> getAll() {
        List<Eleve> eleves = new ArrayList();
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        try {
            eleves = s.createQuery("from Eleve ").list();
        } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("Error connection");
        }

        return (List<Eleve>) eleves;

    }

   /**
    * I want to get the eleve object from the database using the id
    * 
    * @param id the id of the student
    * @return The object of the class Eleve
    */
    @Override
    public Eleve getCode(String id) {
        System.out.println("from get eleve code repo");
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        return (Eleve)s.get(Eleve.class, id);

    }

   /**
    * It creates a new session, starts a transaction, saves the object and commits the transaction
    * 
    * @param eleve the object to be saved
    */
    @Override
    public void create(Eleve eleve) {

        try {


        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        s.save(eleve);
        Tx.commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }
    /**
     * updating a student, given a student object
     * 
     * @param eleve the entity 
     */

    @Override
    public void update(Eleve eleve) {
        System.out.println("trying to update "+ eleve.getCne());
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        s.saveOrUpdate(eleve);
        Tx.commit();
    }

    /**
     * I'm trying to delete an object from the database using the id of the object
     * 
     * @param id the id of the student
     */
    @Override
    public void delete(String id) {
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        Eleve art = this.getCode(id);
        s.delete(art);
        Tx.commit();
    }



}
