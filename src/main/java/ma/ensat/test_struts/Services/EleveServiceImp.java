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
        System.out.println("we are here");

        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        try {
            eleves = s.createQuery("from Eleve").list();
            System.out.println("this shit works");
        } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("Error connection");
        }

        return (List<Eleve>) eleves;
    }

    @Override
    public Eleve getCode(String cne) {
        System.out.println("we are getting the code"+ cne);
        s= HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        return (Eleve)s.get(Eleve.class, cne);
    }

    @Override
    public void create(Eleve eleve) {
        System.out.println("we are trying this");

        try {

            System.out.println("fo9 opensze");
            s = HibernateUtil.getSessionFactory().openSession();
            System.out.println("T7t open session");
            Tx = s.beginTransaction();
            System.out.println("T7t begin transaction");
            s.save(eleve);
            System.out.println("T7t save");
            Tx.commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("zbi hna f create ma khdamsh had 9lawi");
        }
    }

    @Override
    public void update(Eleve eleve) {

        System.out.println("trying to update "+ eleve.getCne());
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();

        s.saveOrUpdate(eleve);
        System.out.println("updating "+ eleve.getCne());

        Tx.commit();
        System.out.println("transaction "+ eleve.getCne()+" new name is: "+ eleve.getNom());
    }

    @Override
    public void delete(String cne) {
        System.out.println("we are deleting!"+ cne);
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        Eleve eleve = this.getCode(cne);
        s.delete(eleve);
        Tx.commit();


    }



}
