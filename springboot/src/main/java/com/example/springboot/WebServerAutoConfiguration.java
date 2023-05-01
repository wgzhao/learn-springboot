package com.example.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Conditional;

@Configuration
public class WebServerAutoConfiguration {

  @Bean
  @Conditional(TomcatCondition.class)
  TomcatServer tomcatServer() {
    return new TomcatServer();
  }
  
  @Bean
  @Conditional(JettyCondition.class)
  JettyServer jettyServer() {
    return new JettyServer();
  }
}
