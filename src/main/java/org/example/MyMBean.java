package org.example;

public interface MyMBean {
    int getValue();
    void setValue(int newValue);

    void changeLogLevelDebug();
    void changeLogLevelInfo();
}
