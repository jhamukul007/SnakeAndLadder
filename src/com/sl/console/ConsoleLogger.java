package com.sl.console;

public class ConsoleLogger implements Logger {

    @Override
    public void log(Object obj) {
        System.out.println(obj);
        System.out.println();
    }
}
