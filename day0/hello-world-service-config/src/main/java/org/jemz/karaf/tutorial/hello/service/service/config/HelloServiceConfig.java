package org.jemz.karaf.tutorial.hello.service.service.config;

import org.jemz.karaf.tutorial.hello.service.IHelloService;

import java.util.Properties;

public class HelloServiceConfig implements IHelloService {

    private String msg = null;

    /**
     * Blueprint: set configuration properties
     */
    public void setHelloServiceConfiguration(Properties properties) {
        msg = (String) properties.get("org.jemz.karaf.tutorial.hello.service.msg");
    }

    @Override
    public String getMessage() {
        return "*** " + msg + " ***";
    }
}
