package nl.qien.demo.Scope;

import nl.qien.demo.model.Dierentuin;
import nl.qien.demo.model.RuimteDierentuin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.reflect.generics.scope.Scope;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ScopeApp {

    @Autowired
    private Dierentuin vogelBos;

    @Autowired
    private RuimteDierentuin ruimteDierentuin;

    @Test
    public void testIfSameInstance(){
        
        Assert.assertTrue(this.vogelBos != ruimteDierentuin.getVogelBos());
    }
}
