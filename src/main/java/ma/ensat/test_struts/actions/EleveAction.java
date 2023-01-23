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


   // Injecting the EleveService into the EleveAction class.
    @Autowired
    private EleveService service ;

  // Injecting the filiereService into the EleveAction class.
    @Autowired
    private FiliereService filiereService;

    Eleve eleve =new Eleve() ;
    public boolean editMode = false;
    public List<Eleve> eleves = new ArrayList();
    public  List<Filiere> filieres;
    private int ref_fil;
    public String codeId;
    public  String nom;
    public String prenom;
    // Message d'erreur
    private String error_message;

    /*
        Cette action permet de récupérer tous les élèves de la base de données en utilisant
        la méthode getAll() de l'objet EleveService. Si la récupération des élèves s'est effectuée avec succès,
        la méthode retourne "success" et redirige vers la page d'affichage des élèves "/afficher.jsp".
         Sinon, elle retourne "error" et redirige vers la page d'erreur "/error.jsp".
        La variable eleves est utilisée pour stocker les élèves récupérés de la base de données.
     */
    @Action(value = "all", results = {
            @Result(name = "success", location = "/afficher.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })
    public String getAll() {


        this.eleves = this.service.getAll();

        return "success";
    }


    /*
    Cette action est utilisée pour afficher la vue de formulaire d'ajout d'un élève.
    Elle utilise une méthode setFilieres pour définir la liste de toutes les filières disponibles dans la vue,
    en utilisant le service de filière pour récupérer cette liste en appelant la méthode getAll().
    Lorsque cette action est appelée avec succès, elle redirige vers la vue "/add_student.jsp"
    pour afficher le formulaire d'ajout d'élève,
    sinon elle redirige vers la vue d'erreur "/error.jsp" en cas d'erreur.
     */
    @Action(value = "add_view", results = {
            @Result(name = "success", location = "/add_student.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })
    public String add_view() throws Exception {

        // we need the list of all filieres in the add eleve view
        this.setFilieres(filiereService.getAll());

        return SUCCESS;
    }



    /*
        Cette action permet de sauvegarder un nouvel élève dans la base de données.
        Elle prend en entrée un objet Eleve et utilise la méthode create du service approprié pour l'enregistrer.
        Si la sauvegarde se déroule avec succès, l'action redirige vers l'action "all" pour afficher la liste des élèves.
        Si une erreur se produit, l'utilisateur est redirigé vers une page d'erreur.
        Si il y a des erreurs de validation, l'utilisateur est redirigé vers la page student.jsp pour corriger les erreurs.
        Si le champ code_fil est vide, il mettra la référence de la filière à null pour l'élève.
     */
    @Action(value = "eleveAction", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "all"}),
            @Result(name = "error", location = "/add_student.jsp"),
            @Result(name = "input" , location = "/student.jsp")
    })
    public String save() {
        Eleve new_eleve = service.getCode(eleve.getCne());
       // Checking if the student already exists in the database.
        if (new_eleve != null) {

            error_message = "L'élève deja exist!!!!!!";

            // charger la liste des filieres
            this.setFilieres(filiereService.getAll());
            return ERROR;
        }
           // Checking if the code_fil is empty, if it is empty it will set the reference of the
           // filiere to null for the eleve.
            if(eleve.getRef_fil().getCode_fil().isBlank()){
                eleve.setRef_fil(null);
            }
            service.create(eleve);
            return "success";

    }

    /*
    Cette action est appelée lorsque l'utilisateur souhaite éditer un élève existant.
    Elle utilise un paramètre appelé "codeId" pour récupérer l'élève à éditer à partir du service.
    Elle définit également une liste de filières pour remplir une liste déroulante dans la vue d'édition.
    Si l'élève est récupéré avec succès, la vue d'édition de l'élève est affichée, sinon une vue d'erreur est affichée.
     */
    @Action(value = "editEleve", results = {
            @Result(name = "success", location = "/editEleve.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })
    public String editEleve() {
        // Trying to get the eleve using the service.
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

    /*
        Cette action a pour but de mettre à jour les informations d'un élève existant dans la base de données.
        Elle est déclenchée lorsque l'utilisateur soumet un formulaire de mise à jour d'élève.
        Elle reçoit les informations saisies dans le formulaire via l'objet "eleve"
        qui est ensuite passé à la méthode "update" de la classe de service pour être enregistré dans la base de données.
        Si la mise à jour a réussi, l'action redirige vers l'action "all" pour afficher la liste des élèves à jour.
        Si une erreur se produit, l'action redirige vers la page d'erreur.
     */
    @Action(value = "updateEleve", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "all"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String updateEleve() {
        //ignore debuging lines
        System.out.println("we are in update"+ "Nom: "+eleve.getNom()+ "prenom: "+eleve.getPrenom());

        service.update(eleve);
        return SUCCESS;

    }

    /*
    Cette action est utilisée pour supprimer un élève de la base de données en utilisant un service.
     Elle prend en paramètre l'identifiant de l'élève à supprimer, appelé "codeId".
     Si la suppression se déroule avec succès, l'utilisateur est redirigé vers l'action "all" qui affiche tous les élèves.
    Si une exception est levée lors de la suppression, l'utilisateur est redirigé vers la page d'erreur.
     */
    @Action(value = "deleteEleve", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "all"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String deleteEleve() {
        try {
            service.delete(codeId);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }


    public Eleve getModel() {
        return eleve;
    }

    /**
     * This function returns a list of students
     * 
     * @return The list of students.
     */
    public List<Eleve> getEleves() {
        return eleves;
    }

    /**
     * This function returns a list of filieres
     * 
     * @return The list of filieres.
     */
    public List<Filiere> getFilieres() {
        return filieres;
    }

    /**
     * This function is used to set the list of filieres
     * 
     * @param filieres the list of filieres
     */
    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }
    // A constructor.
    public EleveAction() {
    }
   /**
    * This function returns the eleve of the class
    * 
    * @return The eleve object.
    */
    public Eleve getEleve() {
        return this.eleve;
    }

   /**
    * This function returns the error message
    * 
    * @return The error message.
    */
    public String getError_message() {
        return error_message;
    }

   /**
    * This function sets the error message to the error message that is passed in
    * 
    * @param error_message The error message that is returned from the server.
    */
    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
