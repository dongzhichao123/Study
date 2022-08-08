package com.example.springboot_demo.excel;


public class EasyExcelUtils {
    public static void main(String[] args) {
        int[] ss = {6, 4, 8, 1, 5, 9};
        for (int s : xuanze(ss)) {
            System.out.print(s);
        }
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
        System.out.println(findMedianinTwoSortedAray(arr1, arr2));
    }

    public static int[] xuanze(int[] s) {
        int len = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            int min = s[i];
            int pin = i;
            for (int j = i + 1; j < s.length; j++) {
                if (s[j] < min) {
                    min = s[j];
                    pin = j;
                }
            }
            s[pin] = s[i];
            s[i] = min;
        }
        return s;
    }

    public static int[] maopao(int[] ss) {
        int length = ss.length;
        for (int i = 0; i < length - i; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (ss[j] > ss[j + 1]) {
                    int a = ss[j + 1];
                    ss[j + 1] = ss[j];
                    ss[j] = a;
                }
            }
        }
        return ss;
    }

    public static int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int m = arr1.length / 2;
        int n = arr2.length / 2;
        return 1;
    }

}

