package CoreJava.Polymorphism;

public class Parent {
    private String name;

    public String  getName(){
        return this.name;
    }
}

class Child extends Parent{
    @Override
    public String getName() {
        return "From Child";
    }

}

class Main{
    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(parent.getName());
    }
}
