package nl.qien.demo.controller;


import nl.qien.demo.Repository.DierentuinRepository;
import nl.qien.demo.model.Dierentuin;
import nl.qien.demo.service.DierentuinService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class DierentuinEndpointTest {


    @Mock
    private DierentuinRepository dierentuinRepository;

    @Mock
    private DierentuinService dierentuinService;

    @InjectMocks
    private DierentuinEndpoint dierentuinEndpoint;

    /*@Test
    public void testUpdateByDieren (){
        Dierentuin dierentuin = Dierentuin.builder().aantalMedewerkers(5).dieren("Walvis").build();

        Mockito.when(dierentuinEndpoint.updateByDieren("Paard", dierentuin)).thenReturn(ResponseEntity.ok("Test Voltooid"));

        Assert.assertEquals(dierentuin.getDieren(), "Paard");

    }*/
}
