package com.sandyspring.config

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext

import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.ServletRegistration

/**
 * Created by sande on 7/1/2017.
 */
class WebApplicationInit implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext()
        rootContext.register(AppRootConfig)
        rootContext.registerShutdownHook()

        servletContext.addListener(new ContextLoaderListener(rootContext))
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("jersey-serlvet",
                        "com.sun.jersey.spi.spring.container.servlet.SpringServlet")
        dispatcher.setLoadOnStartup(1)
        dispatcher.addMapping("/*")
    }
}
