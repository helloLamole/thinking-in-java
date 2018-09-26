package com.ryouji.thinking.in.java.exercise.twentyone.third;

import com.ryouji.thinking.in.java.exercise.twentyone.first.ExerciseOne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExerciseThree {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            executorService.execute(ExerciseOne.getInstance());
        }
        executorService.shutdown();

        executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(ExerciseOne.getInstance());
        }
        executorService.shutdown();

    }
}
