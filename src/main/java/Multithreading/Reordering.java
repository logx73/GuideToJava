package Multithreading;

public class Reordering {
    private volatile static boolean ready;
    private static int number;
    public static class ReaderThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" "+ready);
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static class ReaderThread1 extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" "+ready);
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        System.out.println(ready);
        ReaderThread r1 = new ReaderThread();
        ReaderThread1 r2 = new ReaderThread1();
        r1.start();
        r2.start();
        number = 42;
        ready = true;
    }
}
