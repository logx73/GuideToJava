package Multithreading;

public class Runner {
    public static void main(String[] args) {
        Factorizor factorizor = new Factorizor();

        Thread thread = new Thread(() -> {
            factorizor.threadSafeFactorizer(2);
        });
        
        Thread thread1 = new Thread(() -> {
            factorizor.threadSafeFactorizer(2);
        });
        Thread thread3 = new Thread(() -> {
            factorizor.threadSafeFactorizer(3);
        });

        Thread thread4 = new Thread(() -> {
            factorizor.threadSafeFactorizer(4);
        });

        thread.start();
        thread1.start();
        thread3.start();
        thread4.start();

    }
}
