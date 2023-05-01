package com.example.demo;

import com.example.springboot.ZhaoSpringApplication;
import com.example.springboot.ZhaoSpringBootApplication;
import com.example.springboot.TomcatServer;

@ZhaoSpringBootApplication
public class DemoApp {

  public static void main(String[] args) {
    ZhaoSpringApplication.run(DemoApp.class); 
  }
}
