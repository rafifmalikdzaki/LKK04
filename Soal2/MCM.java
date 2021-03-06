package Soal2;

import java.util.Scanner;

class MatrixMCM {
    double[][] harga;
    int[][] s;

    MatrixMCM(double[][] harga, int[][] s) {
        this.harga = harga;
        this.s = s;
    }
}

public class MCM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan panjang array: ");
        int pjg = input.nextInt();
        int[] p = new int[pjg];
        for (int i = 0; i < pjg; i++) {
            System.out.print("Masukkan angka array ke-" + (i + 1) + ": ");
            p[i] = input.nextInt();
        }
        input.close();
        System.out.println();
        MatrixMCM a = MCMopt(p);
        int[][] s = a.s;
        System.out.println("===========");
        System.out.println("  Tabel K  ");
        System.out.println("===========");
        for (int i = 1; i < s.length; i++) {
            for (int j = 1; j < s[0].length; j++) {
                if (j < i)
                    System.out.printf("%-3s", " ");
                else
                    System.out.printf("%-3s", s[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        double[][] harga = a.harga;
        System.out.println("===========================================");
        System.out.println("                  Tabel Harga  ");
        System.out.println("===========================================");
        for (int i = 1; i < harga.length; i++) {
            for (int j = 1; j < harga[0].length; j++) {
                if (j < i)
                    System.out.printf("%-12s", " ");
                else
                    System.out.printf("%12s", harga[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Hasil Pengurungannya yaitu: ");
        parens(a.s, 1, pjg - 1);
    }

    public static MatrixMCM MCMopt(int[] points) {
        int n = points.length;
        int p[] = points;
        double[][] harga = new double[n][n];
        int[][] s = new int[n][n];
        n = points.length - 1;

        for (int i = 0; i <= n; i++) {
            harga[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                harga[i][j] = Double.POSITIVE_INFINITY;
                for (int k = i; k <= j - 1; k++) {
                    double q = harga[i][k] + harga[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    if (q < harga[i][j]) {
                        harga[i][j] = q;
                        s[i][j] = k;
                    }
                }

            }
        }
        MatrixMCM a = new MatrixMCM(harga, s);
        return a;
    }

    public static void parens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            parens(s, i, s[i][j]);
            parens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
