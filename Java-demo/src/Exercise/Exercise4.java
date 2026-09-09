package Exercise;

import java.util.Scanner;

public class Exercise4 {


    void solveAge(){
        Scanner sc=new Scanner(System.in);
        int year;
        int solveAge;
        System.out.print("Enter year of birth: ");
        year=sc.nextInt();

        solveAge = 2026 - year;

        System.out.println("Your age is: "+solveAge);
    }


    static void main(String[] args) {
        Exercise4 main=new Exercise4();
        main.solveAge();
    }
}
