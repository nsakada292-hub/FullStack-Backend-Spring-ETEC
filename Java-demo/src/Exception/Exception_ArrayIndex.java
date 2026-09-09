package Exception;

public class Exception_ArrayIndex {
    static void main(String[] args) {



        //ArrayIndexOutOfBoundException: use for pel declare index dea ot mean nv knong arr
        int[] age={1,2,3,4};
        try{
            System.out.println(age[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
