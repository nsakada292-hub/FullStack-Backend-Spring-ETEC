public class Array {
    static void main(String[] args) {
        String[] names={"skd", "nin", "dim"};

        for (int i=0; i< names.length; i++){
            System.out.println(names[i]);
        }

        // for each
        for (String skd: names){
            System.out.println("Name: "+ skd );
        }
    }
}
