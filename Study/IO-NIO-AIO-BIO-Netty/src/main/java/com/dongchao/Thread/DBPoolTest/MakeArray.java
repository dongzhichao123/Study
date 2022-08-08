package com.dongchao.Thread.DBPoolTest;

import java.util.Random;

public class MakeArray {
    public static int ARRAY_LENGTH = 100000000;

    public static int[] makeArray() {
        Random random = new Random();

        int result[] = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            result[i] = random.nextInt(ARRAY_LENGTH * 3);
        }
        return result;
    }
}
