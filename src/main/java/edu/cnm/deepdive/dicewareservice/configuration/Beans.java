package edu.cnm.deepdive.dicewareservice.configuration;

import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

  @Value("${bundle.name}") //$ = go to whatever expression is in {} (word-list properties); grabs this from application.yml
  private String bundleName;

  @Bean
  public ResourceBundle getBundle() {
    return ResourceBundle.getBundle(bundleName); //get contents of file
  }

  @Bean
  public Random rng() {
    return new SecureRandom();
  }

}
