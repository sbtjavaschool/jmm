package ru.sbt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FixedThreadPool implements ThreadPool {
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private final int threadCount;

    public FixedThreadPool(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public void start() {
        Runnable task = tasks.poll();
        task.run();
    }

    @Override
    public void execute(Runnable runnable) {
        tasks.add(runnable);
        //notify worker
    }
}
