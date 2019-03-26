package nl.qien.demo.service;


import nl.qien.demo.Repository.DierentuinRepository;
import nl.qien.demo.model.Dierentuin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DierentuinService {

    @Autowired
    private DierentuinRepository dierentuinRepository;

    public Iterable<Dierentuin> findAll() {
        Iterable<Dierentuin> result = this.dierentuinRepository.findAll();
        return result;
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



}
