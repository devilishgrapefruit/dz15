package com.dz;

public class Robot {
    private final Object monitor = new Object();
    Leg left = new Leg("Left", monitor);
    Leg right = new Leg("Right", monitor);
    public Robot() {
    }
    void run() {
        new Thread(left).start();;
        new Thread(right).start();;
    }

}
