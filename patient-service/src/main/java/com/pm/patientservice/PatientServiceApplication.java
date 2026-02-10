package com.pm.patientservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class PatientServiceApplication {
    private static final Logger log = LoggerFactory.getLogger(PatientServiceApplication.class);
    private final Environment environment;

    public PatientServiceApplication(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printUsefulLinks() {
        String port = environment.getProperty("local.server.port", "4000");
        String baseUrl = "http://localhost:" + port;

        log.info("");
        log.info("==============================================================");
        log.info("Application is ready. Quick links:");
        log.info("Swagger UI : {}/swagger-ui/index.html", baseUrl);
        log.info("H2 Console : {}/h2-console", baseUrl);
        log.info("==============================================================");
        log.info("");
    }
}
