package OOP;

class Person{
    private  String name;
    private  String gender;
    public Person(String name, String gender){              // constractor
        this.name=name;
        this.gender=gender;
    }

    public void output(){
        System.out.println(name);
        System.out.println(gender);
    }
}

public class Encap_Constractor {
    static void main(String[] args) {
        Person person=new Person("skd", "male");
        person.output();
    }
}
