package nl.qien.demo.Beans;

import nl.qien.demo.model.Dierentuin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyBeans {

    @Bean
    @Scope("prototype")
    //@Scope("singleton")
    //@Scope("request")
    //@Scope("session") moet met kleine letters.
    public Dierentuin vogelBos() {
        Dierentuin vogelBos = new Dierentuin();
        vogelBos.setDieren("Vogels");
        vogelBos.setAantalMedewerkers(135);
        return vogelBos;
    }

    @Bean
    public Dierentuin apenBerg() {
        Dierentuin apenBerg = new Dierentuin();
        apenBerg.setDieren("Apen");
        apenBerg.setAantalMedewerkers(54);
        return apenBerg;
    }
}
