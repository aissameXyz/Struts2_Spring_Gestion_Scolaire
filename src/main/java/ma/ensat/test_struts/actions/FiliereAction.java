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
import java.util.HashMap;
import java.util.List;

@Controller
public class FiliereAction extends ActionSupport implements ModelDriven {

    private Filiere filiere;
    private List<Filiere> filieres;
    private String codeId;

    // Hashmap contient le count d'etudiants dans chaque filiere(not done by me)
    private HashMap<String, Integer> count;


    // contiendra le message d'erreur qu'on va utiliser pour la validation
    private String error_message;


    // Nbr des eleves non affictés
    private int nbrNonDetermine = 0;


    private int nbrTotalEleves;



    // Creating a list of students.
    private List<Eleve> listeEleve= new ArrayList<>();

   // Injecting the FiliereService into the FiliereController.
    @Autowired

    private FiliereService service;

   // Injecting the EleveService into the EleveController.
    @Autowired
    private EleveService eleveService;


    /*
    Cette action a pour but de charger la liste de toutes les filières disponibles dans la base de données.
     Elle utilise un service de Filiere pour appeler la méthode "getAll()" qui retourne toutes les filières.
     Le résultat de cette méthode est ensuite utilisé pour mettre à jour la propriété "filieres" de cette action.
     Il n'y a pas de résultat spécifique défini pour cette action, car elle ne redirige pas vers une vue particulière,
    mais plutôt sert à préparer les données pourafficher_filiere jsp.
     */
    @Action(value = "allFilieres", results = {
            @Result(name = "success", location = "/afficheher_Filiere.jsp"),
            @Result(name = "error", location = "/error.jsp")
    })
    public String getAll() {

        filieres = service.getAll();

        // get le nombre d'etudians sans filiere
        this.setNbrNonDetermine(service.getCountElevesSansFiliere());

        count = new HashMap();
        for (Filiere filiere : filieres) {
            count.put(filiere.getCode_fil(), service.getElevesCount(filiere.getCode_fil()));
        }

        return "success";
    }

    //action pour remplir la liste des filieres qu'on va utiliser dans afficher_filiere.jsp
  /**
   * /
   *   @Action(value="loadFiliere")
   *     public void loadFiliere(){
   * 
   *         this.setFilieres(service.getAll());
   * 
   *     }
   */
    @Action(value="loadFiliere")
    public void loadFiliere(){

        this.setFilieres(service.getAll());

    }


    /*
    Cette action est utilisée pour récupérer les informations sur les étudiants d'une filière spécifique.
    Le codeId est passé en paramètre, qui est utilisé pour récupérer la filière spécifique à partir de la base de données
    en utilisant la méthode "getCode" du service Filiere. Ensuite, la méthode "getAllEleves" est utilisée pour
    récupérer tous les étudiants de cette filière spécifique, et la méthode "getElevesCount" est utilisée pour
    récupérer le nombre total d'étudiants dans cette filière. Les informations récupérées sont ensuite utilisées
    pour afficher les détails de la filière et les étudiants associés à la page web "filiere_details.jsp".
    La méthode retourne "SUCCESS" après l'exécution de ces actions.
     */
    @Action(value = "listElevesByFiliere", results = {
            @Result(name = SUCCESS, location = "/filiere_details.jsp")
    })
    public String listElevesByFiliere() {

        Filiere filiere = service.getCode(codeId);
        listeEleve= service.getAllEleves(filiere);
        nbrTotalEleves= service.getElevesCount(codeId);
        return SUCCESS;
    }

        /*
        Cette action permet d'ajouter une nouvelle filière.
        Elle utilise l'annotation @Action pour indiquer qu'elle est associée à une action,
        avec un paramètre "addFiliere" qui décrit l'action. Elle utilise également
        l'annotation @Result pour indiquer les résultats possibles de l'action.
        Si l'action est un succès, elle redirige vers l'action "allFilieres",
        sinon elle redirige vers la page d'erreur "/addFiliere.jsp".
        Dans le corps de l'action, il vérifie d'abord si la filière saisie par l'utilisateur existe déjà
        dans la base de données en utilisant la méthode "getCode" de FiliereService.
        S'il existe déjà, il définit un message d'erreur et retourne "error",
        sinon il ajoute la nouvelle filière en utilisant la méthode "add" de FiliereService et retourne "success".
         */
    @Action(value = "addFiliere", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "allFilieres"}),
            @Result(name = "error", location = "/addFiliere.jsp")
    })
    public String addFiliere() {

        // ici on recupère la filiere avec le code saisi par l'utilisateur
        Filiere new_filiere = service.getCode(filiere.getCode_fil());

        //testant si la filiere exist deja et danc on va retourner un message d'erreur

        if (new_filiere != null) {
            error_message = "Cette filiere existe déja!!!";
            return ERROR;
        }

        //la filiere n'existe pas dans la base de données, et danc on l'ajoute

        service.add(filiere);
        return "success";
    }



    // Cette action permet de mettre à jour une filière existante dans la base de données.
    // Elle prend en paramètre un objet filière qui contient les nouvelles informations à mettre à jour.
    // Lorsque l'action est appelée, elle utilise la méthode "update" du service de filière
    // pour mettre à jour la filière dans la base de données. Si l'opération est réussie,
    // l'action redirige vers l'action "allFilieres" pour afficher la liste mise à jour des filières,
    // sinon elle redirige vers la page d'erreur "/error.jsp".
    @Action(value = "updateFiliere", results = {
            @Result(name = "success",  type = "redirectAction", params = {
                    "actionName", "allFilieres"}),
            @Result(name = "error", location = "/error.jsp")
    })
    public String updateFiliere() {

        service.update(filiere);
        return "success";
    }

    /*
    Cette action permet de supprimer une filière en fonction de son code.
    Elle récupère tous les élèves associés à cette filière en
    utilisant la méthode "getAllEleves" de notre service de filière.
    Ensuite, pour chaque élève récupéré, nous mettons leur champ
    de référence à la filière à null pour les désassocier de la filière supprimée.
    Enfin, nous supprimons la filière à l'aide de la méthode "delete"
    de notre service de filière et redirigeons vers une action pour afficher toutes les filières.
    Si une erreur se produit, elle redirige vers une page d'erreur.
     */
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

    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
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
     * This function sets the list of filieres to the list of filieres passed as a parameter
     * 
     * @param filieres the list of filieres
     */
    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

   /**
    * This function returns the codeId of the object
    * 
    * @return The codeId.
    */
    public String getCodeId() {
        return codeId;
    }

   /**
    * This function sets the codeId variable to the value of the codeId parameter
    * 
    * @param codeId The ID of the code to be deleted.
    */
    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    /**
     * The getModel() method is used to return the model object that is used to store the data entered
     * by the user
     * 
     * @return The model is being returned.
     */
    @Override
    public Filiere getModel() {
        return filiere;
    }

   /**
    /**
     * This function sets the number of non-determined values in the Sudoku grid
     * 
     * @param nbrNonDetermine the number of non-determined values in the array
     */
    * This function returns the list of students
    * 
    * @return The list of students.
    */
    public List<Eleve> getListeEleve() {
        return listeEleve;
    }

   /**
    * This function sets the list of students to the list of students passed in as a parameter
    * 
    * @param listeEleve the list of students
    */
    public void setListeEleve(List<Eleve> listeEleve) {
        this.listeEleve = listeEleve;
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
     * This function sets the error message
     * 
     * @param error_message The error message that is returned from the server.
     */
    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

   /**
    * This function returns a HashMap of String and Integer
    * 
    * @return A HashMap of Strings and Integers.
    */
    public HashMap<String, Integer> getCount() {
        return count;
    }

   /**
    * This function takes a HashMap of Strings and Integers as a parameter and sets the count variable
    * to the parameter
    * 
    * @param count A HashMap that contains the word and the number of times it appears in the document.
    */
    public void setCount(HashMap<String, Integer> count) {
        this.count = count;
    }

   /**
    * This function returns the number of non-determined values in the Sudoku grid
    * 
    * @return The number of non-determined values.
    */
    public int getNbrNonDetermine() {
        return nbrNonDetermine;
    }

    public void setNbrNonDetermine(int nbrNonDetermine) {
        this.nbrNonDetermine = nbrNonDetermine;
    }

    /**
     * This function returns the number of total students in the school
     * 
     * @return The number of total students.
     */
    public int getNbrTotalEleves() {
        return nbrTotalEleves;
    }

    /**
     * This function sets the number of total students in the class
     * 
     * @param nbrTotalEleves The total number of students in the class
     */
    public void setNbrTotalEleves(int nbrTotalEleves) {
        this.nbrTotalEleves = nbrTotalEleves;
    }

}
