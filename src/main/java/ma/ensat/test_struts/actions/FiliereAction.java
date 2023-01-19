package ma.ensat.test_struts.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import ma.ensat.test_struts.Services.EleveService;
import ma.ensat.test_struts.Services.FiliereService;
import ma.ensat.test_struts.Services.FiliereServiceImp;
import ma.ensat.test_struts.models.Eleve;
import ma.ensat.test_struts.models.Filiere;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FiliereAction extends ActionSupport implements ModelDriven {
    private Filiere filiere;
    private List<Filiere> filieres;
    private String codeId;
    private List<Eleve> listeEleve= new ArrayList<>();

    @Autowired

    private FiliereService service;

    @Autowired
    private EleveService eleveService;

    @Action(value = "allFilieres", results = {
            @Result(name = "success", location = "/afficheher_Filiere.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })

    public String getAll() {
        filieres = service.getAll();


        return "success";
    }
    @Action(value="loadFiliere")
    public void loadFiliere(){
        System.out.println("hello from load filiere!!!");
        this.setFilieres(service.getAll());
        System.out.println("the size of filieres is: "+ filieres.size());

    }




    @Action(value = "addFiliere", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "allFilieres"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String addFiliere() {
        System.out.println("in add filiere action");
        service.add(filiere);
        return "success";
    }
    @Action(value = "editFiliere", results = {
            @Result(name = "success", location = "/editFiliere.jsp"),
            @Result(name = "error", location = "error.jsp")
    })
    public String editFiliere() {
        filiere = service.getCode(codeId);

        return "success";
    }

    @Action(value = "updateFiliere", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "allFilieres"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String updateFiliere() {
        System.out.println("updating : "+ filiere.getNom_fil());
        service.update(filiere);
        return "success";
    }
    @Action(value = "deleteFiliere", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "allFilieres"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String deleteFiliere() {
        if (codeId != null && !codeId.isBlank()) {

            filiere = service.getCode(codeId);
            listeEleve = service.getAllEleves(filiere);
            for (Eleve eleve : listeEleve) {
                eleve.setRef_fil(null);
                eleveService.update(eleve);
            }
            service.delete(codeId);
            return SUCCESS;
        }
        return ERROR;
        //service.delete(codeId);
        //return "success";
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    @Override
    public Filiere getModel() {
        return filiere;
    }
}
