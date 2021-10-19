package edu.cnm.deepdive.dicewareservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") //everything has to be relative to this URL
public class HelloWorldController {

  @GetMapping(value = "greet") //endpoint
  public String greet(String target) {
    return String.format("Hello, %s", target); //http://localhost:8080/greet?target=World
  }

}
