package Exercise;

import java.util.Scanner;

public class Exercise2 {
//    void inputUsd(){
//        float usd;
//        Scanner sc=new Scanner(System.in);
//        System.out.print("Enter USD to change to KHR: ");
//        usd=sc.nextFloat();
//        float amount = usd*4000;
//        System.out.println("RIEL: "+amount+" Riels");
//    }

    void inputUsd(float usd){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter USD to change to KHR: ");
        usd=sc.nextFloat();
        float amount = usd*4000;
        System.out.println("RIEL: "+amount+" Riels");
    }

    static void main(String[] args) {
        Exercise2 main=new Exercise2();
//        main.inputUsd();
    }
}
