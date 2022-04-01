package com.raptor.chapter.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author raptor
 * @description MinSpeedTimeAndPaths
 * @date 2022/3/30 20:33
 */
public class MinSpeedTimeAndPaths {

    static int[][] map = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };
    static int width = 5;
    static int height = 5;
    static int endX = 3;
    static int endY = 3;
    static int startX = 0;
    static int startY = 1;
    static boolean[][] flag = null;
    static int[][] dis = {
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0},
    };
    static int minTime = Integer.MAX_VALUE;
    static int paths = 0;
    static List<LinkedList> path = new LinkedList<>();

    public static void main(String[] args) {
        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);
        flag = new boolean[width][height];
        LinkedList<Point> linkedList = new LinkedList<>();
        countPaths(start, end, linkedList);

        int res = 0;
        for (LinkedList l : path) {
            if (l.size() == minTime) {
                res++;
            }
        }
        System.out.println(res + " " + minTime);
    }

    private static void countPaths(Point start, Point end, LinkedList<Point> linkedList) {
        if (start.x == end.x && start.y == end.y) {
            if (minTime > paths) {
                minTime = paths;
            }
            path.add((LinkedList) linkedList.clone());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = start.x + dis[i][0];
            int ny = start.y + dis[i][1];
            if (nx >= 0 && nx < width && ny >= 0 && ny < height && !flag[nx][ny] && map[nx][ny] == 0) {
                Point next = new Point(nx, ny);
                flag[nx][ny] = true;
                linkedList.add(next);
                paths++;
                countPaths(next, end, linkedList);
                flag[nx][ny] = false;
                paths--;
                linkedList.removeLast();
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
