package com.example.springboot;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class JettyServer implements WebServer{

  @Override
  public void start(AnnotationConfigWebApplicationContext webApplicationContext) {
    System.out.println("Starting Jetty.....");
  }
  
}
