package edu.cnm.deepdive.dicewareservice.controller;

import edu.cnm.deepdive.dicewareservice.service.PassphraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passphrases")
public class PassphraseController {

  private final PassphraseGenerator generator;

  @Autowired //looking for PassphrseGenerator to inject into constructor
  public PassphraseController(
      PassphraseGenerator generator) {
    this.generator = generator;
  }

  @GetMapping("/transient") //transient => this is not meant for database storage
  public String[] generate(int length) {
    return generator.generate(length);
  }
}
