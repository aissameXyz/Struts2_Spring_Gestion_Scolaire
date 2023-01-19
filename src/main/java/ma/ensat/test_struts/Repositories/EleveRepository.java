package ma.ensat.test_struts.Repositories;

import ma.ensat.test_struts.models.Eleve;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EleveRepository{

    List<Eleve> getAll();
    Eleve getCode(String id);
    void create(Eleve type);
    void update(Eleve type);
    void delete(String id);

}
