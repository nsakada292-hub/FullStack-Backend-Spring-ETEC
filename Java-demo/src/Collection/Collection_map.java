package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collection_map {
    static void main(String[] args) {
//        List<Map<String, Object>> people=new ArrayList<>();
//        Map<String, Object> map=new HashMap<>();
//
//        map.put("id", 1);
//        map.put("name", "SKD");
//        map.put("gender", "Male");
//
//        for (Object m : map.values()){
//            System.out.println(m);
//        }
//
//        System.out.println(map.get("id"));
//        System.out.println(map.get("name"));
//        System.out.println(map.get("gender"));



        List<Map<String, Object>> list=new ArrayList<>();

        Map<String, Object> m1=new HashMap<>();
        m1.put("id", 1);
        m1.put("name", "SKD");
        m1.put("gender", "Male");

        Map<String, Object> m2 =new HashMap<>();
        m2.put("id", 2);
        m2.put("name", "NIN");
        m2.put("gender", "Female");

        Map<String, Object> m3 =new HashMap<>();
        m3.put("id", 3);
        m3.put("name", "DIM");
        m3.put("gender", "Male");

        list.add(m1);
        list.add(m2);
        list.add(m3);

        for (Map<String, Object> person : list) {
            System.out.println("ID     : " + person.get("id"));
            System.out.println("Name   : " + person.get("name"));
            System.out.println("Gender : " + person.get("gender"));
            System.out.println("-------------------");
        }



    }
}
