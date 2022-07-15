package Soal1;

import java.util.*;

public class LexicographicOrderPermutations {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int permNum = factorial(arr.length);
        System.out.println(permNum);
        for (int i = 0; i < 8; i++) {
            getNextLexicographicOrderPermutation(arr, arr.length);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return factorial(n * factorial(n - 1));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void getNextLexicographicOrderPermutation(int[] currPerm, int length) {
        int i = length - 1;
        while (i >= 0 && currPerm[i - 1] >= currPerm[i]) {
            i--;
        }

        if (i < 0) {
            return;
        }

        int j = length;
        while (j > i && currPerm[j - 1] <= currPerm[i - 1]) {
            j--;
        }
        swap(currPerm, i - 1, j - 1);
        i++;
        j = length;
        while (i < j) {
            swap(currPerm, i - 1, j - 1);
            i++;
            j--;
        }
    }
}