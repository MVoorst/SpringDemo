package nl.qien.demo.Repository;

import nl.qien.demo.model.Dierentuin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

@Repository
public interface DierentuinRepository extends CrudRepository<Dierentuin, Long> {

    Optional<Dierentuin> findByDieren(String dieren);

    @Query("SELECT d FROM Dierentuin d WHERE d.aantalMedewerkers = ?1")
    Optional<Dierentuin> findByAantalMedewerkers(int aantalMedewerkers);

}
