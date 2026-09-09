package Collection;

import java.util.HashSet;
import java.util.Set;

public class Collection_set {
    static void main(String[] args) {
        Set<String> set=new HashSet<>();

        set.add("skd");
        set.add("nin");
        set.add("dim");
        set.add("poy");
        set.add("ter");
        set.add("skd");// pel yg brer set nus pel yg store data value doch knea vea output only 1

        for (String name : set){
            System.out.println(name);
        }
    }
}
