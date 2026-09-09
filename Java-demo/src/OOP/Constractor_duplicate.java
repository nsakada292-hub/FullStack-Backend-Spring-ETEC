package OOP;

class Person3{
    private int id;
    private String name;
    private String gender;
    public Person3(int id, String name){            // constractor 1
        this.id=id;
        this.name=name;
    }
    public Person3(int id, String name, String gender){      // constractor 2
        this.id=id;
        this.name=name;
        this.gender=gender;
    }

    public void output(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(gender);
    }
}

public class Constractor_duplicate {
    static void main(String[] args) {
        Person3 person=new Person3(101, "Sakada", "Male");
        person.output();
    }
}
