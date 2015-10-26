package org.jemz.karaf.tutorial.hello.service.config.internal;

import org.jemz.karaf.tutorial.hello.service.IHelloService;

import java.util.Properties;

public class HelloServiceConfig implements IHelloService {

    private static final String HELLO_SERVICE_MSG_CONFIG = "org.jemz.karaf.tutorial.hello.service.msg";

    private String msg = null;

    /**
     * Blueprint reference: init-method
     */
    public void startup() {
        System.out.println("HELLO SERVICE CONFIG STARTED");
    }

    /**
     * Blueprint reference: destroy-method
     */
    public void shutdown() {
        System.out.println("HELLO SERVICE CONFIG SHUTDOWN");
    }


    /**
     * Blueprint: set configuration properties
     */
    public void setHelloServiceConfiguration(Properties properties) {
        msg = (String) properties.get(HELLO_SERVICE_MSG_CONFIG);
    }

    @Override
    public String getMessage() {
        return "*** " + msg + " ***";
    }
}
