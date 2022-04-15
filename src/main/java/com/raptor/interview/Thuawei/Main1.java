package com.raptor.interview.Thuawei;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        myString[] list = new myString[15000 + 5];
        HashSet<String> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < m; i++) {
            String s = scanner.next();
            String titleStr = scanner.nextLine();
            titleStr = s + titleStr;
            String[] titleSplit = titleStr.split(" ");
            for (int j = 0; j < titleSplit.length; j++) {
                String s1 = titleSplit[j];
                if (set.contains(s1)) {
                    for (int k = 0; k < index; k++) {
                        if (s1.equals(list[k].str)) {
                            list[k].title += 1;
                            break;
                        }
                    }
                } else {
                    set.add(s1);
                    myString myString = new myString();
                    myString.str = s1;
                    myString.title += 1;
                    myString.titleIndex += 1;
                    list[index++] = myString;
                }
            }
            String contentStr = scanner.nextLine();
            String[] contentSplit = contentStr.split(" ");
            for (int j = 0; j < contentSplit.length; j++) {
                String s2 = contentSplit[j];
                if (set.contains(s2)) {
                    for (int k = 0; k < index; k++) {
                        if (s2.equals(list[k].str)) {
                            list[k].content += 1;
                            break;
                        }
                    }
                } else {
                    set.add(s2);
                    myString myString = new myString();
                    myString.str = s2;
                    myString.content += 1;
                    myString.contentIndex += 1;
                    list[index++] = myString;
                }
            }
        }

//        for (int i = 0; i < index; i++) {
//            System.out.println(list[i].str + " " + list[i].title + " " + list[i].content);
//        }
        Arrays.sort(list, new Comparator<myString>() {
            @Override
            public int compare(myString o1, myString o2) {
                if (o1 != null && o2 != null) {
                    int num1 = o1.title * 3 + o1.content;
                    int num2 = o2.title * 3 + o2.content;
                    if (num1 == num2 && o1.title != o2.title) {
                        return o2.title - o1.title;
                    }
                    if (num1 == num2 && o1.title == o2.title) {
                        return o2.titleIndex - o1.titleIndex;
                    } else {
                        return num2 - num1;
                    }
                }
                return 1;
            }
        });

        for (int j = 0; j < n - 1; j++) {
            System.out.print(list[j].str + " ");
        }
        System.out.println(list[n - 1].str);
    }

    static class myString {
        String str;
        int title = 0;
        int content = 0;
        int titleIndex = 0;
        int contentIndex = 0;

        public myString() {
        }

        @Override
        public String toString() {
            return "str:" + str + " total:" + (title + content);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            myString myString = (myString) o;
            return Objects.equals(str, myString.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str);
        }
    }
}


/*
3 1
xinguan feiyan xinzeng bendi quezhen anli
ju baodao chengdu xinzeng xinguan feiyan bendi quezhen anli yili shenzhen xinzeng bendi quezhen anli liangli yiqing zhengti kongzhi lianghao
xinguan yimiao linchuang shiyan
wuzhong xinguan yimiao tongguo sanqi linchaung shiyan xiaoguo lianghao
* */