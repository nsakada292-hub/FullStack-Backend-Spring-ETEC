package Exercise;

import java.util.Scanner;

class Student{
    private int id;
    private String name;
    private String gender;
    private int age;

    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter id: ");
        id=sc.nextInt();
        System.out.print("Enter name: ");
        name= sc.next();
        System.out.print("Enter gender: ");
        gender=sc.next();
        System.out.print("Enter age: ");
        age=sc.nextInt();
    }
    public void output(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Age: "+age);
    }

}

public class Exercise8 {
    static void main(String[] args) {
        Student stu=new Student();
        stu.input();
        stu.output();
    }
}
