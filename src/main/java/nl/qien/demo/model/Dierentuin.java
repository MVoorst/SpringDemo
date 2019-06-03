package nl.qien.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.qien.demo.annotation.Ruimte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Ruimte("RuimteDierenTuin")
//@Builder
@Data
public class Dierentuin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String dieren;

    private int aantalMedewerkers;



}
