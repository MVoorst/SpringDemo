package nl.qien.demo.service;

import lombok.extern.slf4j.Slf4j;
import nl.qien.demo.Repository.DierentuinRepository;
import nl.qien.demo.model.Dierentuin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class DierentuinServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(DierentuinServiceTest.class);

    @Mock
    private DierentuinRepository dierentuinRepository;

    @InjectMocks
    private DierentuinService dierentuinService;

    @Test
    public void testFindByAantalMedewerkers(){
        logger.info("testFindByAantalMedewerkers van start");
        Dierentuin dierentuin = new Dierentuin();
        dierentuin.setAantalMedewerkers(3);
        //Dierentuin dierentuin = Dierentuin.builder().aantalMedewerkers(3).build();

        Mockito.when(dierentuinRepository.findByAantalMedewerkers(dierentuin.getAantalMedewerkers())).thenReturn(Optional.of(dierentuin));

        Optional<Dierentuin> optionalDierentuin = dierentuinRepository.findByAantalMedewerkers(dierentuin.getAantalMedewerkers());

        Assert.assertEquals(optionalDierentuin.get().getAantalMedewerkers(), dierentuin.getAantalMedewerkers());

        logger.info("testFindByAantalMedewerkers einde");
    }

    @Test
    public void testFindByDieren(){
        logger.info("testFindByDieren van start");
        Dierentuin dierentuin = new Dierentuin();
        dierentuin.setAantalMedewerkers(3);
        //Dierentuin dierentuin = Dierentuin.bu
        //Dierentuin dierentuin = Dierentuin.builder().dieren("Aap").build();

        Mockito.when(dierentuinRepository.findByDieren(dierentuin.getDieren())).thenReturn(Optional.of(dierentuin));

        Optional<Dierentuin> optionalDierentuin = dierentuinRepository.findByDieren(dierentuin.getDieren());

        Assert.assertEquals(optionalDierentuin.get().getDieren(), dierentuin.getDieren());

        logger.info("testFindByDieren einde");
    }

    @Spy
    private List<Dierentuin> dierentuinList = new ArrayList<>();

    @Test
    public void testAddToDierentuinList(){
        Dierentuin dierentuin = new Dierentuin();
        Dierentuin dierentuin1 = new Dierentuin();

        dierentuin.setDieren("Beren");
        dierentuin1.setDieren("Olifanten");
        dierentuinList.add(dierentuin);
        dierentuinList.add(dierentuin1);

        Mockito.verify(dierentuinList).add(dierentuin);
        Mockito.verify(dierentuinList).add(dierentuin1);

        Assert.assertEquals("Olifanten", dierentuin1.getDieren());
        Assert.assertEquals("Beren", dierentuin.getDieren());
    }

    @Captor
    private List<Dierentuin> dierentuinList1 = new ArrayList<>();


}
