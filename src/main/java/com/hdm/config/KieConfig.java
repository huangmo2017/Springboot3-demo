package com.hdm.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KieConfig {

    private final KieServices kieServices = KieServices.Factory.get();
    private KieFileSystem kieFileSystem;
    private KieBuilder kieBuilder;
    private KieContainer kieContainer;

    @Bean
    public KieContainer kieContainer() {
         kieFileSystem = kieServices.newKieFileSystem();
         kieBuilder = kieServices.newKieBuilder(kieFileSystem);
         kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
         return kieContainer;
     }

     @Bean
     public KieSession kieSession() {
         return kieContainer.newKieSession("kieSession");
     }
}
