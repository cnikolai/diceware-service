package edu.cnm.deepdive.dicewareservice.controller;

import edu.cnm.deepdive.dicewareservice.service.PassphraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //any method, unless otherwise stated below is a controller method
//if we use @RestController, that puts @ResponseBody on every method
@RequestMapping("/passphrases")
public class PassphraseController {

  private final PassphraseGenerator generator;

  @Autowired //looking for PassphraseGenerator to inject into constructor
  public PassphraseController(
      PassphraseGenerator generator) {
    this.generator = generator;
  }

  //returning the actual response
  @ResponseBody //rest form
  @GetMapping(value = "/transient", produces = MediaType.APPLICATION_JSON_VALUE) //transient => this is not meant for database storage
  public String[] generate(@RequestParam(defaultValue = "5") int length) {
    return generator.generate(length);
  }

  //returning the name of the template
  @GetMapping(value = "/transient", produces = MediaType.TEXT_HTML_VALUE)
  public String generate(@RequestParam(defaultValue = "5") int length, Model model) {//returning the name of the template
    model.addAttribute("words", generator.generate(length));
    return "passphrase";
  }
}
