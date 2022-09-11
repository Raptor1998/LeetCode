package com.raptor.T200;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/3  16:53
 */
public class ReplaceTest {

    public static void main(String[] args) {
        String question = "\\、#%&！！!!包含匹配";
        // 去除表情符号
        question = question.replaceAll("\\[.+]", "");
        // 去除符号
        question = question.replaceAll("[？!！;；。\\\\\"'|、}{「」】【\\[\\]：@#¥$*()（）～·]+", "");
        System.out.println(question);


        Set<String> objects = new HashSet<>();
        objects.add("AA");
        objects.add("BB");
        objects.add(new String("AA"));
        System.out.println(objects);

    }
}

