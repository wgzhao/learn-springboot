package com.example.springboot;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public interface WebServer {

  public void start(AnnotationConfigWebApplicationContext webApplicationContext);
  
}
