package com.dz;

public class Leg implements Runnable {
    private final String name;
    private Object monitor;

    Leg(String name, Object monitor) {
        this.name = name;
        this.monitor = monitor;
    }

    public void run() {
        for (int i = 0; i < 6; i++) {
            synchronized (monitor) {
                step();
                monitor.notify();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void step() {
        System.out.println(name);
    }
}
