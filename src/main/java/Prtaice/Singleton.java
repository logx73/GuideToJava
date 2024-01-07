package Prtaice;

public final class Singleton {
    private static volatile Singleton singleton = null;
    private static Object newObj = new Object();
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton != null){
            return singleton;
        }

      synchronized(newObj){
          if(singleton == null){
              return new Singleton();
          }
        }

        return singleton;
    }
}
