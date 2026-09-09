package Exception;

public class Exception_Arithmatic {
    static void main(String[] args) {


        // ArithmeticException: brer for check tha lbeab kit lek yg trv ot, ber khos vea lot jol catch
        try{
            int num= 10/0;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
