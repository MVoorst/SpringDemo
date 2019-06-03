package nl.qien.demo.controller;

import feign.Headers;
import feign.RequestLine;
import nl.qien.demo.model.Dierentuin;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface DierentuinClient {

    @RequestLine("GET")
    List<Dierentuin> findAll();

    @RequestLine("GET /{id}")
    Dierentuin findById(@Param("id")long id);

    @RequestLine("POST")
    @Headers({"Content-Type: application/json"})
    void create(Dierentuin user);
}

