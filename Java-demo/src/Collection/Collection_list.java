package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Collection_list {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size;
        boolean isStop=false;
        System.out.print("Enter size of data: ");
        size= sc.nextInt();
        List<Integer> list=new ArrayList<>(size);

        while (true){
//            Scanner sc=new Scanner(System.in);
            int option;
//            boolean isStop;

            System.out.println("1, Add data");
            System.out.println("2, Read data");
            System.out.println("3, Update data");
            System.out.println("4, Delete data");
            System.out.println("5, Exist Program");
            System.out.print("Choose option (1-5): ");
            option=sc.nextInt();

            switch (option){
                case 1:{
//                    isStop = false;
                    for (int i=0; i<size; i++){
                        System.out.print("Enter data "+(i+1)+" : ");
                        list.add(sc.nextInt());
                    }

                    isStop=true;
                    break;
                }
                case 2:{
//                    List<Integer> list=new ArrayList<>();
                    if (!isStop){
                        System.out.println("Cannot read data without add data! Please add data first.");
                        break;
                    }

                    for (int i=0; i< list.toArray().length; i++){
                        System.out.println("Data "+(i+1)+": "+list.get(i) );
                    }

//                    for (int i=0; i<size; i++){
//                        System.out.print("Enter data"+(i+1)+" : ");
//                        list.add(sc.nextInt());
//                    }
                    break;
                }
                case 3:{
                    int index;
                    int setData;
//                    List<Integer> list=new ArrayList<>();
                    if (!isStop){
                        System.out.println("Cannot read data without add data! Please add data first.");
                        break;
                    }

                    System.out.print("Enter data number: ");
                    index= sc.nextInt();
                    System.out.print("Enter new number: ");
                    setData= sc.nextInt();
                    list.set(index-1, setData);

                    for (int i=0; i< list.toArray().length; i++){
                        System.out.println("Data "+(i+1)+": "+list.get(i) );
                    }
                    break;
                }
                case 4:{
                    int removeNum;

                    if (!isStop){
                        System.out.println("Cannot read data without add data! Please add data first.");
                        break;
                    }

                    System.out.print("Enter data number to remove: ");
                    removeNum= sc.nextInt();
                    list.remove(removeNum-1);

                    for (int i=0; i< list.toArray().length; i++){
                        System.out.println("Data "+(i+1)+": "+list.get(i) );
                    }
                    break;
                }
                case 5:{
                    System.out.println("Exist Program...");
                    return;
                }
                default:{
                    System.out.println("Invalid Option! Please choose option from (1-5).");
                }
            }



        }
    }
}
