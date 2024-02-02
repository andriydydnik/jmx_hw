package org.example;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Hello world!
 */
public class App {
    private int value;

    private static MBeanServer madeMBeaServer() throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        StandardMBean mbean = new StandardMBean(new MyMBeanImpl(), MyMBean.class);

        ObjectName mbeanName = new ObjectName("com.example:type=MyMBean");

        mbs.registerMBean(mbean, mbeanName);
        return mbs;
    }

    public static void main(String[] args) throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException, IOException {
        MBeanServer mbs = madeMBeaServer();
        System.in.read();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private static App app;

    public static synchronized App getInstance() {
        if (app == null)
            app = new App();
        return app;
    }
}
