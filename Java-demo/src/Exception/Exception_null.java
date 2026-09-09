package Exception;

public class Exception_null {
    static void main(String[] args) {



        // NullPointerException: brer for string muy ng <  null > but ke hv < .length() > nus code error
        String name=null;
        try{
            System.out.println(name.length());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
