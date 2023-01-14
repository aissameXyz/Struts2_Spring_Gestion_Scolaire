package ma.ensat.test_struts.actions;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.httpserver.Authenticator;
import ma.ensat.test_struts.Services.EleveService;
import ma.ensat.test_struts.Services.EleveServiceImp;
import ma.ensat.test_struts.models.Eleve;

import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.Result;




import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class EleveAction  extends ActionSupport implements ModelDriven  {



    private EleveService service = new EleveServiceImp();


    Eleve eleve =new Eleve() ;

    public boolean editMode = false;

    public EleveAction() {
    }
    public List<Eleve> eleves = new ArrayList();

    public Eleve getEleve() {
        return this.eleve;
    }
    public String codeId;

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


        System.out.println("we are her");
        //eleves.add(new Eleve("V567", "HOHO", "L7DAD", 99));
        this.eleves = this.service.getAll();

        return "success";
    }

    @Action(value = "eleveAction", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "all"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String save() {
        System.out.println("eleve li 9adina: "+ eleve.getNom());
        try {
            service.create(eleve);


            //service.create(new Eleve("V567", "HOHO", "L7DAD", 99));

            return "success";
        }catch (Exception ex){
            System.out.println("ereeeur");
           return "error";

    }


    }
    @Action(value = "editAction", results = {
            @Result(name = "success", location = "/afficher.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })
    public String edit() {
        this.eleve = this.service.getCode(this.codeId);
        this.eleves = this.service.getAll();
        this.editMode = true;
        return "success";
    }




}
