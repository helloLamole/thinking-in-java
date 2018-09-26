package com.ryouji.thinking.in.java.exercise.twentyone.fifth;

import java.util.concurrent.*;

public class ExerciseFive implements Callable<Integer> {

    private int n;

    public static ExerciseFive getInstance(int n) {
        return new ExerciseFive(n);
    }

    ExerciseFive(int n) {
        this.n = n;
    }

    public Integer call() throws Exception {
        int last = 0;
        int current = 1;
        int sum = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            System.out.println(current);
            sum += current;
            temp = current;
            current += last;
            last = temp;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> futureTask = executorService.submit(ExerciseFive.getInstance(10));
        System.out.println(futureTask.get());
        executorService.shutdown();
    }
}
