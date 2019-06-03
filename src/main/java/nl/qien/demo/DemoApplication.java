package nl.qien.demo;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import nl.qien.demo.controller.DierentuinClient;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	//private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);


	public static void main(String[] args) {

		//logger.warn("Applicatie start!");
		SpringApplication.run(DemoApplication.class, args);
	}

}
