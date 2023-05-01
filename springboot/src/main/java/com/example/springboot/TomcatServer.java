package com.example.springboot;

import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TomcatServer implements WebServer {

  @Override
  public void start(AnnotationConfigWebApplicationContext webApplicationContext) {
    System.out.println("Starting Tomcat......");

    Tomcat tomcat = new Tomcat();
    // Server server = tomcat.getServer();

    Service service = tomcat.getService();
    // Service service = server.findService("Tomcat");
    Connector connector = new Connector();
    connector.setPort(8080);

    Engine engine = new StandardEngine();
    engine.setDefaultHost("0.0.0.0");

    Host host = new StandardHost();
    host.setName("0.0.0.0");

    String contextPath = "";
    Context context = new StandardContext();
    context.setPath(contextPath);
    context.addLifecycleListener(new Tomcat.FixContextListener());

    host.addChild(context);
    engine.addChild(host);
    service.setContainer(engine);
    service.addConnector(connector);

    tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(webApplicationContext));
    context.addServletMappingDecoded("/*", "dispatcher");

    try {
      tomcat.start();
      tomcat.getServer().await();
    } catch (LifecycleException e) {
      e.printStackTrace();
    }
  }
}
