package OOP;

class Person1{
    private String name;
    private String gender;
    public Person1(){
        name="";
        gender="";
    }

    public void setName(String name){
        this.name=name;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
}

public class Encap_set_get {
    static void main(String[] args) {
        Person1 person=new Person1();
        person.setName("skd");
//        person.getGender("male");
        person.setGender("male");
        System.out.println(person.getName());
        System.out.println(person.getGender());
    }
}
