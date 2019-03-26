package nl.qien.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dierentuin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String dieren;

    private int aantalMedewerkers;

    public int getAantalMedewerkers() {
        return aantalMedewerkers;
    }

    public void setAantalMedewerkers(int aantalMedewerkers) {
        this.aantalMedewerkers = aantalMedewerkers;
    }

    public String getDieren() {
        return dieren;
    }

    public void setDieren(String dieren) {
        this.dieren = dieren;
    }



}
