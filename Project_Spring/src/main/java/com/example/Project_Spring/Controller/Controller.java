package com.example.Project_Spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
   @GetMapping("/")
    public List<Map<String, Object>> index(){
       List<Map<String, Object>> list=new ArrayList<>();
       Map<String, Object> map=new HashMap<>();
       map.put("id", 1);
       map.put("name", "sakada");
       map.put("gender", "male");
       map.put("email", "nsakada292@gmail.com");
       list.add(map);

       Map<String, Object> map1=new HashMap<>();
       map1.put("id", 2);
       map1.put("name", "lynin");
       map1.put("gender", "female");
       map1.put("email", "lynin292@gmail.com");
       list.add(map1);

       return list;
   }
}












