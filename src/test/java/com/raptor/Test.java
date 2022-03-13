package com.raptor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;

/**
 * @author raptor
 * @description Test
 * @date 2021/6/9 9:40
 */
public class Test {
    @org.junit.Test
    public void testObjectMapper() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Man man = new Man();
        System.out.println(objectMapper.writeValueAsString(man));
    }
    public static class Man implements Serializable {
        private int age;
        public String name;
    }
}
