package com.example.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingApplication {

  public static void main(String[] args) {
    SpringApplication.run(GreetingApplication.class, args);
  }

  private int port;


  @EventListener
  public void ready(WebServerInitializedEvent event) {
    this.port = event.getWebServer().getPort();
  }

  @GetMapping("/hello/{name}")
  String greet(@PathVariable String name) {
    return "Hello, " + name + " localhost:" + port + "!";
  }

}
