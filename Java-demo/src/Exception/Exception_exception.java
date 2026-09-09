package Exception;

public class Exception_exception {
    static void main(String[] args) {



        // Exception: use to catch all error, can use it in any situation
        try{
            int age=Integer.parseInt("abc");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
