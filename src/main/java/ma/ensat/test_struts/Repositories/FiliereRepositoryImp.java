package ma.ensat.test_struts.Repositories;

import ma.ensat.test_struts.Config.HibernateUtil;
import ma.ensat.test_struts.models.Eleve;
import ma.ensat.test_struts.models.Filiere;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FiliereRepositoryImp implements FiliereRepository{
    List<Filiere> filieres = new ArrayList();

    static Session s;
    static Transaction Tx;
   /**
    * It returns a list of all the filieres in the database
    * 
    * @return A list of filieres
    */
    @Override
    public List<Filiere> getAll() {
        System.out.println("from getall filiere repo");
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        try {
            filieres = s.createQuery("from Filiere").list();
        } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("Error connection");
        }

        return (List<Filiere>) filieres;
    }
    /**
    getting the filieres from the database using it's primary key
    @return a filiere 
     */
    @Override
    public Filiere getCode(String id) {

        System.out.println("we are getting the code"+ id);
        s= HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        return (Filiere) s.get(Filiere.class, id);
    }

    /**
     * I'm trying to save a new object of type Filiere in the database
     * 
     * @param type is the object that I want to save
     */
    @Override
    public void create(Filiere type) {


        try {


            s = HibernateUtil.getSessionFactory().openSession();

            Tx = s.beginTransaction();

            s.save(type);

            Tx.commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }

    }

  /**
   * It updates a row in the database
   * 
   * @param type Filiere
   */
    @Override
    public void update(Filiere type) {
        System.out.println("trying to update "+ type.getCode_fil());
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();

        s.saveOrUpdate(type);
        System.out.println("updating "+ type.getCode_fil());

        Tx.commit();
        System.out.println("transaction "+ type.getCode_fil()+" new name is: "+ type.getCode_fil());
    }

   /**
    * I'm trying to delete a row from a table in my database using hibernate
    * 
    * @param id the id of the object to be deleted
    */
    @Override
    public void delete(String id) {
        System.out.println("we are deleting!"+ id);
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        Filiere filiere = this.getCode(id);
        s.delete(filiere);
        Tx.commit();

    }

    /**
     * I want to get the number of students in a specific class.
     * I'm using Hibernate and I'm trying to get the number of students in a specific class.
     * I'm using the following code:
     * <code>String hql = "SELECT COUNT(*) FROM Eleve WHERE ref_fil.code_fil = :code_fil";
     * Query query = session.createQuery(hql);
     * query.setParameter("code_fil", code_fil);
     * Long result = (Long) ((org.hibernate.query.Query&lt;?&gt;) query).uniqueResult();
     * count = result.intValue();
     * </code>
     * But I get the following error:
     * <code>java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Long
     * </code>
     * I don't understand why I get this error.
     * I tried to change
     * 
     * @param code_fil the code of the class
     * @return The number of students in a class.
     */
    @Override
    public int getElevesCount(String code_fil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int count = 0;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM Eleve WHERE ref_fil.code_fil = :code_fil";
            Query query = session.createQuery(hql);
            query.setParameter("code_fil", code_fil);
            Long result = (Long) ((org.hibernate.query.Query<?>) query).uniqueResult();
            count = result.intValue();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count;
    }

   /**
    * I'm trying to get the number of students without a filiere.
    * I'm using Hibernate and MySQL.
    * I'm getting this error:
    * <code>java.lang.ClassCastException: java.lang.Long cannot be cast to java.lang.Integer
    * </code>
    * I've tried to change the return type of the function to long but it didn't work.
    * I've also tried to change the return type of the function to int and cast the result to int but
    * it didn't work.
    * I've also tried to change the return type of the function to Integer but it didn't work.
    * I've also tried to change the return type of the function to Long but it didn't work.
    * I've also tried to change the return type of the function to long and cast the result to long but
    * it didn't work.
    * I've also tried to change the return type of the function to long and cast the result to
    * 
    * @return The number of students without a filiere.
    */
    @Override
    public int getCountElevesSansFiliere() {
        int count = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Tx = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(*) FROM Eleve WHERE ref_fil IS NULL");
            count = ((Long) ((org.hibernate.query.Query<?>) query).uniqueResult()).intValue();
            Tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            Tx.rollback();
        }
        return count;
    }

 // It's a method that returns a list of students in a specific class.
    public List<Eleve> getAllEleves(Filiere filiere){
        List<Eleve> eleves = new ArrayList<>();
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            Tx = s.beginTransaction();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Eleve> cq = cb.createQuery(Eleve.class);
            Root<Eleve> root = cq.from(Eleve.class);

            cq.select(root);
            cq.where(cb.equal(root.get("ref_fil"), filiere));

            eleves = s.createQuery(cq).getResultList();
            Tx.commit();
        } catch (Exception ex) {
            if (Tx != null) {
                Tx.rollback();
            }
            ex.printStackTrace();
            System.out.println("Exception message dans get eleves of filieres: " + ex.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }

        return eleves;

    }


}
