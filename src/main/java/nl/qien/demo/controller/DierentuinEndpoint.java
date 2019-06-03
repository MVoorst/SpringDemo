package nl.qien.demo.controller;

import nl.qien.demo.Repository.DierentuinRepository;
import nl.qien.demo.model.Dierentuin;
import nl.qien.demo.model.RuimteDierentuin;
import nl.qien.demo.service.DierentuinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("dierentuin")
public class DierentuinEndpoint {

    @Autowired
    private DierentuinService dierentuinService;

    @Autowired
    private DierentuinRepository dierentuinRepository;

    @Autowired
    private RuimteDierentuin ruimteDierentuin;

    @GetMapping
    public ResponseEntity<Iterable<Dierentuin>> findAll() {
        return ResponseEntity.ok(this.dierentuinService.findAll());
    }

    @GetMapping("/dieren/{dieren}")
    public ResponseEntity <Optional<Dierentuin>> findByDieren(@PathVariable("dieren") String dieren) {
        return ResponseEntity.ok(this.dierentuinService.findByDieren(dieren));
    }

    @GetMapping
    @RequestMapping("/aantal/{aantalmedewerkers}")
    public ResponseEntity <Optional<Dierentuin>> findByAantalMedewerkers(@PathVariable("aantalmedewerkers") int aantalmedewerkers){
        return ResponseEntity.ok(this.dierentuinService.findByAantalMedewerkers(aantalmedewerkers));
    }

    @GetMapping("/getruimtedierentuin")
    public ResponseEntity <RuimteDierentuin> printRuimteDierentuin (){
        System.out.println(this.ruimteDierentuin);
        return ResponseEntity.ok(this.ruimteDierentuin);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Dierentuin dierentuin) {
        this.dierentuinService.save(dierentuin);
        return ResponseEntity.ok("Toppie");
    }

    @PutMapping
    @RequestMapping("/update/{dieren}")
    public ResponseEntity updateByDieren (@PathVariable ("dieren") String dieren, @RequestBody Dierentuin dierentuin ){

        this.dierentuinService.updateByDieren(dieren, dierentuin);
        return ResponseEntity.ok(dieren + " geupdate");
        /*finally{
            throw new NullPointerException();
        }*/

    }


}
