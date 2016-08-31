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
        for (int i = 0; i < threadCount; i++) {
            new Worker().start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        tasks.add(runnable);
        //notify worker
    }

    public class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable poll = tasks.poll();
                poll.run(); // handle exception
            }
        }
    }
}
