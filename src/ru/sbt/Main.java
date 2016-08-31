package ru.sbt;

public class Main {
    public static void main(String[] args) {
        ThreadPool pool = new FixedThreadPool(3);

        pool.execute(()-> System.out.println(1));
        pool.execute(()-> System.out.println(2));
        pool.execute(()-> System.out.println(3));
        pool.execute(()-> System.out.println(4));

        pool.start();
    }
}
