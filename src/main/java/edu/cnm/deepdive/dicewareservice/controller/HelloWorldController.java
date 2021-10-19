package edu.cnm.deepdive.dicewareservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") //everything has to be relative to this URL
public class HelloWorldController {

  @GetMapping(value = "greet") //endpoint
  public String greet(@RequestParam(name = "t", required = false, defaultValue = "World!") String target) { //http://localhost:8080/greet?t=World
    return String.format("Hello, %s", target); //http://localhost:8080/greet?target=World
  }

  @GetMapping("goodjob")
  public String goodJob() {
    return "You're building a webserver then soon onto a webservice, congratulations!";
  }

}
