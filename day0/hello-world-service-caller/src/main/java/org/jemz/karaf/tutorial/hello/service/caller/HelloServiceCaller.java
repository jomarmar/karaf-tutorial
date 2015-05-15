package org.jemz.karaf.tutorial.hello.service.caller;

import org.jemz.karaf.tutorial.hello.service.IHelloService;

/**
 * Created by jmartinez on 5/15/15.
 */
public class HelloServiceCaller {
    private IHelloService helloService = null;

    /**
     * Blueprint reference: bind-method
     * @param serv
     */
    public void setHelloService(IHelloService serv) {
        helloService = serv;
    }

    /**
     * Blueprint reference: unbind-method
     * @param serv
     */
    public void unsetHelloService(IHelloService serv) {
        helloService = null;
    }
}


