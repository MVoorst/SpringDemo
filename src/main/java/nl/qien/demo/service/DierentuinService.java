package nl.qien.demo.service;


import nl.qien.demo.Repository.DierentuinRepository;
import nl.qien.demo.aop.Timed;
import nl.qien.demo.model.Dierentuin;
import nl.qien.demo.model.RuimteDierentuin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.Optional;

@Service
public class DierentuinService {

    @Autowired
    private DierentuinRepository dierentuinRepository;


    @Timed
    public Iterable<Dierentuin> findAll() {
        // before  // here it happens upto proceeding
        Iterable<Dierentuin> result = this.dierentuinRepository.findAll();
        return result;
        // after
    }

    public Optional<Dierentuin> findByDieren(String dieren) {
        return this.dierentuinRepository.findByDieren(dieren);
    }

    public Optional<Dierentuin> findByAantalMedewerkers(int aantalMedewerkers) {
        return this.dierentuinRepository.findByAantalMedewerkers(aantalMedewerkers);
    }

    @Transactional
    public void save(Dierentuin dierentuin) {
        this.dierentuinRepository.save(dierentuin);
    }

    @Transactional
    public void updateByDieren(String dieren, Dierentuin inputDierentuin) {
        Optional<Dierentuin> opt = this.dierentuinRepository.findByDieren(dieren);
        if(opt.isPresent()) {
            Dierentuin dierentuin = opt.get();
            dierentuin.setAantalMedewerkers(inputDierentuin.getAantalMedewerkers());
            dierentuin.setDieren(inputDierentuin.getDieren());
            this.dierentuinRepository.save(dierentuin);
        }
    }

}
