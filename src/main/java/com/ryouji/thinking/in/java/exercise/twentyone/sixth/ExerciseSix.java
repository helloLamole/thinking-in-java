package com.ryouji.thinking.in.java.exercise.twentyone.sixth;

import com.ryouji.thinking.in.java.chapter.twentyone.LiftOff;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExerciseSix extends LiftOff {
    private static Random random;

    public static ExerciseSix getInstance(Random randomSeed) {
        ExerciseSix.random = randomSeed;
        return new ExerciseSix();
    }

    public void run() {
        int sleepTime = random.nextInt(10);
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            System.out.println("Thread " + id + " had been sleeped " + sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            executorService.execute(ExerciseSix.getInstance(random));
        }
        executorService.shutdown();
    }
}
