package org.jemz.karaf.tutorial.hello.service.caller.internal;

import org.jemz.karaf.tutorial.hello.service.IHelloService;

/**
 * Created by jmartinez on 5/15/15.
 */
public class HelloServiceCaller {
    private IHelloService helloService = null;

    /**
     * Blueprint reference: init-method
     */
    public void startup() {
        System.out.println("HELLO SERVICE CALLER STARTED");
    }

    /**
     * Blueprint reference: destroy-method
     */
    public void shutdown() {
        System.out.println("HELLO SERVICE CALLER SHUTDOWN");
    }

    /**
     * Blueprint reference: bind-method
     * @param serv
     */
    public void setHelloService(IHelloService serv) {
        helloService = serv;
        System.out.println("SET HELLO SERVICE: " + helloService.getMessage());
    }

    /**
     * Blueprint reference: unbind-method
     * @param serv
     */
    public void unsetHelloService(IHelloService serv) {
        helloService = null;
        System.out.println("UNSET HELLO SERVICE");
    }
}


