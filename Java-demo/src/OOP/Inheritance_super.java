package OOP;

class Animal{
    protected String name;
    public Animal(String name){
        this.name=name;
    }
    public void output(){
        System.out.println(name);
    }
}

class Dog extends Animal{
    private String gender;
    public Dog(String name, String gender){
        super(name);
        this.gender=gender;
    }
    public void output(){
        super.output();
        System.out.println(gender);
    }
}

public class Inheritance_super {
    static void main(String[] args) {
        Dog dog=new Dog("Jasmine", "Female");
        dog.output();
    }
}
