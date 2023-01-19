package ma.ensat.test_struts.actions;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.sun.net.httpserver.Authenticator;
import ma.ensat.test_struts.Services.EleveService;
import ma.ensat.test_struts.Services.EleveServiceImp;
import ma.ensat.test_struts.Services.FiliereService;
import ma.ensat.test_struts.Services.FiliereServiceImp;
import ma.ensat.test_struts.models.Eleve;

import ma.ensat.test_struts.models.Filiere;
import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
public class EleveAction  extends ActionSupport implements ModelDriven  {


    @Autowired
    private EleveService service ;
    private FiliereService filiereService= new FiliereServiceImp();



    Eleve eleve =new Eleve() ;

    public boolean editMode = false;

    public EleveAction() {
    }
    public List<Eleve> eleves = new ArrayList();

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public  List<Filiere> filieres;


    private int ref_fil;

    public Eleve getEleve() {
        return this.eleve;
    }
    public String codeId;
    public  String nom;
    public String prenom;
    //pagination
    private int page = 1;
    private int totalPages;

    public Eleve getModel() {
        return eleve;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }




    @Action(value = "all", results = {
            @Result(name = "success", location = "/afficher.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })

    public String getAll() {




        //eleves.add(new Eleve("V567", "HOHO", "L7DAD", 99));
        this.eleves = this.service.getAll();

        return "success";
    }

    // Methode pour afficher la vue pour ajouter eleve
    @Action(value = "add_view", results = {
            @Result(name = "success", location = "/add_student.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })
    public String add_view() throws Exception {

        // we need the list of all filieres in the add eleve view
        this.setFilieres(filiereService.getAll());

        return SUCCESS;
    }
    //update filling list

    @Action(value = "eleveAction", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "all"}),
            @Result(name = "error", location = "/error.jsp"),
            @Result(name = "input" , location = "/student.jsp")
    })
    public String save() {
        System.out.println("eleve li 9adina: "+ eleve.getNom());
        try {
            if(eleve.getRef_fil().getCode_fil().isBlank()) {
                eleve.setRef_fil(null);

            }
            service.create(eleve);

            //service.create(new Eleve("V567", "HOHO", "L7DAD", 99));

            return "success";
        }catch (Exception ex){
            System.out.println("ereeeur");
           return "error";

    }


    }
    @Action(value = "editEleve", results = {
            @Result(name = "success", location = "/editEleve.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })
    public String editEleve() {
        try {
            System.out.println("we are in edit"+ codeId);
            // Retrieve the eleve using the service
            eleve = service.getCode(codeId);
            this.setFilieres(filiereService.getAll());
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
    @Action(value = "updateEleve", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "all"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String updateEleve() {

        System.out.println("we are in update"+ "Nom: "+eleve.getNom()+ "prenom: "+eleve.getPrenom());



        service.update(eleve);
        return SUCCESS;

    }
    @Action(value = "deleteEleve", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "all"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String deleteEleve() {
        try {
            // Delete the eleve using the service
            System.out.println("we are trying this");
            service.delete(codeId);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }




}
