package ru.sbt;

import java.util.ArrayList;
import java.util.List;

public class FixedThreadPool implements ThreadPool {
    private final List<Runnable> tasks = new ArrayList<>();
    private final int threadCount;

    public FixedThreadPool(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public void start() {
    }

    @Override
    public void execute(Runnable runnable) {
        tasks.add(runnable);
        //notify worker
    }
}
