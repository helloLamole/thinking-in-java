package com.ryouji.thinking.in.java.exercise.twentyone.first;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExerciseOne implements Runnable {
    private static int index = 0;
    private final int id = index++;

    public static ExerciseOne getInstance() {
        return new ExerciseOne();
    }

    private ExerciseOne() {
        System.out.println(this.getClass().getSimpleName() + ":" + id + ". inited");
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello World");
            Thread.yield();
        }
        System.out.println(this.getClass().getSimpleName() + ":" + id + ". destory");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(ExerciseOne.getInstance());
        }
        executorService.shutdown();
    }
}
