package org.jemz.karaf.tutorial.hello.service.basic;

import org.jemz.karaf.tutorial.hello.service.IHelloService;

public class HelloServiceBasic implements IHelloService {
    @Override
    public String getMessage() {
        return "I am a HelloServiceBasic!!";
    }
}
