package ma.ensat.test_struts.Repositories;

import ma.ensat.test_struts.Config.HibernateUtil;
import ma.ensat.test_struts.models.Eleve;
import ma.ensat.test_struts.models.Filiere;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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

    @Override
    public Filiere getCode(String id) {

        System.out.println("we are getting the code"+ id);
        s= HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        return (Filiere) s.get(Filiere.class, id);
    }

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

    @Override
    public void delete(String id) {
        System.out.println("we are deleting!"+ id);
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        Filiere filiere = this.getCode(id);
        s.delete(filiere);
        Tx.commit();

    }

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
