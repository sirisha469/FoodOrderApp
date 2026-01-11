package com.siri.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {
  
  @GetMapping("/hi")
  public String hi(){
    return "Hello siri! please maintain consistency";
  }
}
