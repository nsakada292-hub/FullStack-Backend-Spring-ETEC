package Exercise;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        String username = "";
        String email = "";
        String password = "";
        boolean isRegistered = false;

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit Program");
            System.out.print("Choose option: ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.print("Username: ");
                    username = sc.next();
                    System.out.print("Email: ");
                    email = sc.next();
                    System.out.print("Password: ");
                    password = sc.next();
                    isRegistered = true;
                    System.out.println("Successfully Registered!");
                    break;
                }
                case 2: {
                    if (!isRegistered) {
                        System.out.println("No account found! Please register first.");
                        break;
                    }

                    System.out.print("Enter your email: ");
                    String loginEmail = sc.next();
                    System.out.print("Enter your password: ");
                    String loginPassword = sc.next();

                    if (email.equals(loginEmail) && password.equals(loginPassword)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Incorrect email or password. Please try again!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Exiting Program...");
                    return;
                }
                default: {
                    System.out.println("Invalid option! Please choose 1, 2, or 3.");
                }
            }
        }
    }
}