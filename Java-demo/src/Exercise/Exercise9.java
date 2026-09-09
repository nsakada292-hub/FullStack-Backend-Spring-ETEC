package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise9 {
    static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String name="";
        int option=0;
        boolean isStoped = false;

        while (true){
            System.out.println("1. Add 10 Names");
            System.out.println("2. Show All Names");
            System.out.println("3. Filter Names Starting with 'D'");
            System.out.println("4. Convert Names to UPPERCASE");
            System.out.println("5. Count Names Longer Than 3 Characters");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-7): ");
            option= sc.nextInt();

            switch (option){
                case 1:{
                    for (int i=0; i<10; i++){
                        System.out.print("Enter name "+(i+1)+" :");
                        list.add(sc.next());
                    }
                    isStoped=true;
                    break;
                }
                case 2:{
                    if (!isStoped){
                        System.out.println("Cannot show name without add name! Please add 10 name first.");
                        break;
                    }
                    for (int i=0; i< list.toArray().length; i++){
                        System.out.println("Name "+(i+1)+": "+list.get(i) );
                    }
                    break;
                }
                case 3:{
                    if (!isStoped){
                        System.out.println("Cannot Filter Names Starting with 'D' without add name! Please add 10 name first.");
                        break;
                    }
                    List<String> filter_D = list.stream()
                            .filter(name_D -> name_D.startsWith("D") || name_D.startsWith("d"))
                            .collect(Collectors.toList());
                    if (filter_D.isEmpty()){
                        System.out.println("No names starting with 'D' found.");
                    }else {
                        filter_D.forEach(name_D -> System.out.println("• " + name_D));
                        System.out.println("Total name: " + filter_D.size());
                    }
                    break;
                }
                case 4:{
                    if (!isStoped){
                        System.out.println("Cannot covert name without add name! Please add 10 name first.");
                        break;
                    }
                    List<String> convertName= list.stream()
                            .map(nameConvert -> nameConvert.toUpperCase())
                            .collect(Collectors.toList());
                    convertName.forEach(nameConvert -> System.out.println("• " + nameConvert));
                    break;
                }
                case 5:{
                    if (!isStoped){
                        System.out.println("Cannot count name without add name! Please add 10 name first.");
                        break;
                    }
                    long count= list.stream()
                            .map(nameCount -> nameCount.length()>3)
                            .count();   // count nis trv brer jmuy long always
                    list.stream()
                            .filter(nameCount -> nameCount.length()>3)
                            .forEach(nameCount -> System.out.println("• " + nameCount + " (" + nameCount.length () + " letters)"));
                    break;
                }
                case 6: {
                    System.out.println("Exiting Program...");
                    return;
                }
                default: {
                    System.out.println("Invalid option! Please choose 1, 2, 3, 4, 5 or 6");
                }
            }


        }
    }
}
