package nl.qien.demo.feign;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import nl.qien.demo.controller.DierentuinClient;
import nl.qien.demo.model.Dierentuin;

import java.util.List;

public class FeignDierentuinApp {
    private static final String API = "http://localhost:8080/dierentuin";

    public static void main(String[] args) {
        DierentuinClient dierentuinClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(DierentuinClient.class))
                .logLevel(Logger.Level.FULL)
                .target(DierentuinClient.class, API);


        Dierentuin dierentuin = new Dierentuin();
        dierentuin.setAantalMedewerkers(4);
        dierentuin.setDieren("Zebra");

        Dierentuin dierentuin2 = new Dierentuin();
        dierentuin2.setAantalMedewerkers(563);
        dierentuin2.setDieren("Apen");

        dierentuinClient.create(dierentuin);
        //dierentuinClient.create(dierentuin2);

        List<Dierentuin> dierentuins = dierentuinClient.findAll();
        }





}
