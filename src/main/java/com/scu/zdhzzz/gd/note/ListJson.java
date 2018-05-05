package com.scu.zdhzzz.gd.note;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ListJson {
    public static void main(String[] args) {
        try {
            new ListJson().method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void method1() throws Exception{
        String jsonString="[{\"id\":1},{\"id\":2}]";
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, B.class);
//如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);
        List<B> lst =  (List<B>)mapper.readValue(jsonString, javaType);



        List<B> beanList = mapper.readValue(jsonString, new TypeReference<List<B>>() {});

        System.out.println(lst);
    }

    static class A{
        private List<B> list;

        public List<B> getList() {
            return list;
        }

        public void setList(List<B> list) {
            this.list = list;
        }
    }

    static class B {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
