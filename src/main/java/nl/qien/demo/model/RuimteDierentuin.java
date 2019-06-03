package nl.qien.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuimteDierentuin {

    @Autowired
    private Dierentuin vogelBos;

    @Autowired
    private Dierentuin apenBerg;

    public Dierentuin getVogelBos() {
        return vogelBos;
    }

    public void setVogelBos(Dierentuin vogelBos) {
        this.vogelBos = vogelBos;
    }

    public Dierentuin getApenBerg() {
        return apenBerg;
    }

    public void setApenBerg(Dierentuin apenBerg) {
        this.apenBerg = apenBerg;
    }


}
