package com.raptor.T200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/7  19:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            int m = Integer.parseInt(scanner.nextLine());
            HashMap<String, String> map = new HashMap<>(n);
            for (int i = 0; i < m; i++) {
                String line = scanner.nextLine();
                String[] node = line.split(" ");
                String par = node[0];
                for (int j = 1; j < node.length; j++) {
                    map.put(node[j], par);
                }
            }
            String targetLine = scanner.nextLine();
            String[] target = targetLine.split(" ");
            ArrayList<String> path1 = new ArrayList<>();
            ArrayList<String> path2 = new ArrayList<>();
            findPar(path1, target[0], map);
            findPar(path2, target[1], map);
            int index1 = 0;
            int index2 = 0;
            while (true){

            }
        }
    }

    public static List<String> findPar(List<String> path, String node, HashMap<String, String> map) {
        if (!map.containsKey(node)) {
            return path;
        }
        String newNode = map.get(node);
        path.add(newNode);
        return findPar(path, newNode, map);
    }

}