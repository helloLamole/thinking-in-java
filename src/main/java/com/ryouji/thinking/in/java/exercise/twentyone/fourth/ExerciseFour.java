package com.ryouji.thinking.in.java.exercise.twentyone.fourth;

import com.ryouji.thinking.in.java.exercise.twentyone.second.ExerciseTwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExerciseFour {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            executorService.execute(ExerciseTwo.getInstance());
        }
        executorService.shutdown();

        executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(ExerciseTwo.getInstance());
        }
        executorService.shutdown();

    }
}
