package com.ryouji.thinking.in.java.chapter.twentyone;

public class DaemonSpawn implements Runnable {
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
