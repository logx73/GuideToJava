package Prtaice;

public final class Singleton {
    private static volatile Singleton singleton = null;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton != null){
            return singleton;
        }

      synchronized(new Object()){
          if(singleton == null){
              return new Singleton();
          }
        }

        return singleton;
    }
}
