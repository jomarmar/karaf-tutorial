package org.jemz.karaf.tutorial.hello.service.config.admin.internal;

import org.jemz.karaf.tutorial.hello.service.IHelloService;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Properties;

public class HelloServiceConfigAdmin implements IHelloService {

    // Service PID - persistent-id
    private static final String HELLO_SERVICE_CONFIG_ADMIN_PID =  "org.jemz.karaf.tutorial.hello.service.config.admin";

    public static final String HELLO_SERVICE_MSG_CONFIG = "org.jemz.karaf.tutorial.hello.service.msg";
    /*
     Hidden properties
     */
    private static final String HELLO_SERVICE_MSG_CONFIG_SUFFIX = "org.jemz.karaf.tutorial.hello.service.msg.suffix";
    private static final String HELLO_SERVICE_MSG_CONFIG_PREFIX = "org.jemz.karaf.tutorial.hello.service.msg.prefix";

    private String msg = null;
    private String suffix = "";
    private String prefix = "";

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
    public void setHelloServiceConfiguration(ConfigurationAdmin cfgAdmin) {
        try {
            Configuration config = cfgAdmin.getConfiguration(HELLO_SERVICE_CONFIG_ADMIN_PID);
            Dictionary<String, Object> serviceProps = config.getProperties();
            Enumeration<String> en = serviceProps.keys();
            while (en.hasMoreElements()) {
                String key = en.nextElement();
                if(key.equals(HELLO_SERVICE_MSG_CONFIG)) {
                    msg = (String) serviceProps.get(key);
                } else if (key.equals(HELLO_SERVICE_MSG_CONFIG_SUFFIX)) {
                    suffix = (String) serviceProps.get(key);
                } else if (key.equals(HELLO_SERVICE_MSG_CONFIG_PREFIX)) {
                    prefix = (String) serviceProps.get(key);
                } else {
                    System.out.println("UNUSED KEY: " + key + " VAL: " + (String)serviceProps.get(key));
                }
            }
        } catch (IOException e) {
            // Ignore error
        }
    }

    @Override
    public String getMessage() {
        return prefix + msg + suffix;
    }
}
