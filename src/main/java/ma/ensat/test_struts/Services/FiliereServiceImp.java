package ma.ensat.test_struts.Services;

import ma.ensat.test_struts.Config.HibernateUtil;
import ma.ensat.test_struts.Repositories.EleveRepository;
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
    private EleveRepository repo;

    @Override
    public List<Filiere> getAll() {
        System.out.println("we are here in get all fileoere" );

        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        try {
            filieres = s.createQuery("from Filiere").list();
            System.out.println("this shit works");
        } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("Error connection");
        }

        return (List<Filiere>) filieres;
    }

    @Override
    public Filiere getCode(String code) {
        System.out.println("we are getting the code"+ code);
        s= HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        return (Filiere) s.get(Filiere.class, code);
    }

    @Override
    public void add(Filiere filiere) {
        System.out.println("we are trying this");

        try {

            System.out.println("fo9 opensze");
            s = HibernateUtil.getSessionFactory().openSession();
            System.out.println("T7t open session");
            Tx = s.beginTransaction();
            System.out.println("T7t begin transaction");
            s.save(filiere);
            System.out.println("T7t save");
            Tx.commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("zbi hna f create ma khdamsh had 9lawi");
        }
    }

    @Override
    public void update(Filiere filiere) {

        System.out.println("trying to update "+ filiere.getCode_fil());
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();

        s.saveOrUpdate(filiere);
        System.out.println("updating "+ filiere.getCode_fil());

        Tx.commit();
        System.out.println("transaction "+ filiere.getCode_fil()+" new name is: "+ filiere.getCode_fil());
    }

    @Override
    public void delete(String code) {
        System.out.println("we are deleting!"+ code);
        s = HibernateUtil.getSessionFactory().openSession();
        Tx = s.beginTransaction();
        Filiere filiere = this.getCode(code);
        s.delete(filiere);
        Tx.commit();


    }


}
