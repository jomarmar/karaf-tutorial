package org.jemz.karaf.tutorial.hello.service.basic.internal;

import org.jemz.karaf.tutorial.hello.service.IHelloService;

public class HelloServiceBasic implements IHelloService {

    /**
     * Blueprint reference: init-method
     */
    public void startup() {
        System.out.println("HELLO SERVICE BASIC STARTED");
    }

    /**
     * Blueprint reference: destroy-method
     */
    public void shutdown() {
        System.out.println("HELLO SERVICE BASIC SHUTDOWN");
    }

    @Override
    public String getMessage() {
        return "I am a HelloServiceBasic!!";
    }
}
