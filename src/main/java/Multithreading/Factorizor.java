package Multithreading;

import java.math.BigInteger;
import java.util.Arrays;

public class Factorizor {
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;
    private int cachedCounter;
    private int counter;
    public void threadSafeFactorizer(int num){
        BigInteger factoringNumber = BigInteger.valueOf(num);
        System.out.println("Factoring Number "+factoringNumber+" "+Thread.currentThread());
        BigInteger[] factors = null;
        System.out.println("Factors "+factors+" "+Thread.currentThread());
        synchronized (this){
            System.out.println("In synchronized block "+Thread.currentThread());
            counter++;
            if(factoringNumber.equals(lastNumber)){
                System.out.println("In Cached block "+Thread.currentThread());
                cachedCounter++;
                factors = lastFactors.clone();
                System.out.println("In Cacheed block Ends"+Thread.currentThread());
            }
            System.out.println("In Synchronized block Ends"+Thread.currentThread());
        }
        if(factors == null){

            factors = factors(num);
            Arrays.stream(factors).forEach(System.out::println);
            synchronized (this){
                System.out.println("In Factor block "+Thread.currentThread());
                lastNumber = factoringNumber;
                lastFactors = factors.clone();
                System.out.println("In Factor block Ends"+Thread.currentThread());
            }
        }
    }

    private BigInteger[] factors(int num) {
        BigInteger[] bigIntegers = new BigInteger[num];
        int j = 0 ;
        for(int i=1;i<=num;i++){
            if(num%i==0){
                bigIntegers[j] = new BigInteger(String.valueOf(i));
                j++;
            }
        }
        return bigIntegers;
    }
}
