package com.ryouji.thinking.in.java.exercise.twentyone.second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExerciseTwo implements Runnable {
    private int n;
    ExerciseTwo(int n) {
        this.n = n;
    }

    public static ExerciseTwo getInstance() {
        return new ExerciseTwo(10);
    }

    public void run() {
        int last0 = 0;
        int last1 = 1;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = last0 + last1;
            System.out.println(last1);
            last0 = last1;
            last1 = temp;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(ExerciseTwo.getInstance());
        executorService.shutdown();
    }
}
