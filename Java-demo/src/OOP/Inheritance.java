package OOP;

class Person2{
    protected int id=1;
    protected String name="skd";
    public void output(){
        System.out.println(id);
        System.out.println(name);
    }
}

class Teacher extends Person2{

}
class Student extends Teacher{

}

public class Inheritance {
    static void main(String[] args) {
        Student stu=new Student();
        stu.output();
        Teacher teacher=new Teacher();
        teacher.output();
    }
}
