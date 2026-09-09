import java.util.Scanner;

public class Input_scanner {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String name;
        int age;
        String gender;
        String uni;
        String phone_num;
        String address;

        System.out.println("======== Enter Information ========");
        System.out.print("Enter Your name:");
        name=sc.nextLine();
        System.out.print("Enter Your age: ");
        age=sc.nextInt();
        System.out.print("Enter Your gender: ");
        gender=sc.next();
        System.out.print("Enter Your university: ");
        uni=sc.next();
        System.out.print("Enter Your phone number: ");
        phone_num=sc.next();
        sc.nextLine();
        System.out.print("Enter Your Address: ");
        address= sc.nextLine();

        System.out.println("======== Information ========");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
        System.out.println("University: "+uni);
        System.out.println("Phone Number: "+phone_num);
        System.out.println("Address: "+address);
    }
}
