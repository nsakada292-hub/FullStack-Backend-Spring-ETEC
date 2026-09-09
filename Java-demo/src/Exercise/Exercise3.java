package Exercise;

import java.util.Scanner;

public class Exercise3 {

    void bonusSalary(){
        Scanner sc=new Scanner(System.in);
        String name;
        String gender;
        double salary;
        int hour;
        double bonus=0;
        double totalSalary;

        System.out.print("Enter name: ");
        name=sc.next();
        System.out.print("Enter gender: ");
        gender= sc.next();
        System.out.print("Enter hour: ");
        hour= sc.nextInt();
        System.out.print("Enter salary: ");
        salary=sc.nextDouble();

        if (hour>=100){
            bonus= 50;
        }

        totalSalary = salary+bonus;

        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Hour: "+hour+"h");
        System.out.println("Salary: "+salary);
        System.out.println("Get bonus: "+bonus);
        System.out.println("Total salary: "+totalSalary);
    }



    static void main(String[] args) {
        Exercise3 main=new Exercise3();

        main.bonusSalary();
    }
}
