public class Function {
    // non- return, no par
    void show(){

        System.out.println("Hello ah poy");
    }

    // non-return, with par
    void show2(String txt){

        System.out.println(txt);
    }

    // return, no par
    int sum(){
        int a=10;
        int b=20;
        return a+b;
    }

    // retrun, with par
    int sum2(int a, int b){

        return a+b;
    }


    static void main(String[] args) {
//        Function main=new Function();
//        //
//        main.show();
//
//        //
//        main.show2("Kob");
//
//        //
//        System.out.println(main.sum());
//
//        //
//        System.out.println(main.sum2(10,29));
        Function skd=new Function();

        skd.show();

        skd.show2("handsome_skd");

        System.out.println(skd.sum());

        System.out.println(skd.sum2(12, 3));
    }
}
