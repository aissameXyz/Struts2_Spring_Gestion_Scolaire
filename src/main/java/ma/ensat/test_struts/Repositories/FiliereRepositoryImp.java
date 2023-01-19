package ma.ensat.test_struts.Repositories;

import ma.ensat.test_struts.Config.HibernateUtil;
import ma.ensat.test_struts.models.Filiere;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FiliereRepositoryImp implements FiliereRepository{
    List<Filiere> filieres = new ArrayList();
    static Session s;
    static Transaction Tx;
    @Override
    public List<Filiere> getAll() {

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
}
