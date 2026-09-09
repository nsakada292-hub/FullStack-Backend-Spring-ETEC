package Exception;

public class Exception_NumberFormat {
    static void main(String[] args) {



        // NumberFormatException: use for jg do string to int (java cannot change from string to int)
        try{
            int age=Integer.parseInt("abc");
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}
