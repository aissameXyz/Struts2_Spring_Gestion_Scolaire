package ma.ensat.test_struts.Services;

import ma.ensat.test_struts.models.Eleve;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EleveService {
    List<Eleve> getAll();
    Eleve getCode(String cne);
    void create(Eleve eleve);
    void update(Eleve eleve);
    void delete(String cne);
}
