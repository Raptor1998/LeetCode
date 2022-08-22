package com.enternal.meituan;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/20  10:26
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] ps = new int[n];
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                ps[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextInt();
            }
            List<Exam> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Exam exam = new Exam(ps[i], scores[i]);
                list.add(exam);
            }
            Collections.sort(list, new Comparator<Exam>() {
                @Override
                public int compare(Exam o1, Exam o2) {
                    BigDecimal bigDecimal1 = new BigDecimal(o1.getLose());
                    BigDecimal bigDecimal2 = new BigDecimal(o2.getLose());
                    int i = bigDecimal1.compareTo(bigDecimal2);
                    return -i;
                }
            });
            double ans = 0;
            int index = 0;
            for (Exam exam : list) {
                if (index < m) {
                    ans += exam.getScore() * 1.0;
                    index++;
                } else {
                    double temp = (exam.getP() * 1.0 / 100) * exam.getScore();
                    ans += temp;
                }
            }
            String res = String.format("%.2f", ans);
            System.out.println(res);
        }
    }
}

class Exam {
    private int p;
    private int score;

    private double lose ;

    public Exam(int p, int score) {
        this.p = p;
        this.score = score;
        lose = ((100 - p) * 1.0 / 100) * score;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getLose() {
        return lose;
    }

    public void setLose(double lose) {
        this.lose = lose;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "p=" + p +
                ", score=" + score +
                ", lose=" + lose +
                '}';
    }
}
