package Exercise;

import java.util.Scanner;

public class Exercise6 {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size;
        System.out.print("Enter size of array: ");
        size=sc.nextInt();

        int[] numbers=new int[size];


        for (int i=0; i<size; i++){
            System.out.print("Enter number of array: ");
            numbers[i]=sc.nextInt();
        }
        for (int j=0; j<size; j++){
            System.out.println("Number: "+numbers[j]);
        }
    }
}
