package Exercise;

import java.util.Scanner;

public class Exercise1 {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int id;
        String name;
        int age;
        String gender;
        double score1,score2,score3;
        double total;
        double avg;

        System.out.print("Enter Name: ");
        name=sc.nextLine();
        System.out.print("Enter ID: ");
        id=sc.nextInt();
        System.out.print("Enter Age: ");
        age=sc.nextInt();
        System.out.print("Enter Gender: ");
        gender=sc.next();
        System.out.print("Enter Score1: ");
        score1=sc.nextInt();
        System.out.print("Enter Score2: ");
        score2=sc.nextInt();
        System.out.print("Enter Score3: ");
        score3=sc.nextInt();

        total=score3+score1+score2;

        avg=total/3;

        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
        System.out.println("Score 1: "+score1);
        System.out.println("Score 2: "+score2);
        System.out.println("Score 3; "+score3);
        System.out.println("Total Score: "+total);
        System.out.println("Average: "+avg);

        if (avg>=90){
            System.out.println("You got a grade A");
        } else if (avg>=80) {
            System.out.println("You got a grade B");
        }else if (avg>=70) {
            System.out.println("You got a grade C");
        }else if (avg>=60) {
            System.out.println("You got a grade D");
        }else if (avg>=50) {
            System.out.println("You got a grade E");
        }else {
            System.out.println("You failed!");
        }


    }
}
