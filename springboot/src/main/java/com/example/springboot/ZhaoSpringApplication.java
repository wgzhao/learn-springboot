package com.example.springboot;

import java.util.Map;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Hello world!
 *
 */
public class ZhaoSpringApplication 
{
    private static Map<String, WebServer> beansOfType;

    public static void run(Class clazz)
    {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(clazz);

        appContext.refresh();

        WebServer webServer = getWebServer(appContext);
        webServer.start(appContext);
    }

    private static WebServer getWebServer( AnnotationConfigWebApplicationContext appContext) {
        
        Map<String, WebServer> webServers = appContext.getBeansOfType(WebServer.class, false, false);
        
        if (webServers.isEmpty()) {
            throw new NullPointerException();
        }
        if (webServers.size() > 1) {
            throw new IllegalStateException();
        }
        
        return webServers.values().stream().findFirst().get();
    }
}
