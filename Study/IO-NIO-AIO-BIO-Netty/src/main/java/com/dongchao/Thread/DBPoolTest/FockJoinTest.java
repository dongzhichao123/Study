package com.dongchao.Thread.DBPoolTest;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FockJoinTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] src = MakeArray.makeArray();
        SumTasl sumTasl = new SumTasl(src, 0, src.length - 1);
        long start = System.currentTimeMillis();

        pool.invoke(sumTasl);//同步调用
        System.out.println("Task is Running.....");

        System.out.println("The count is "+sumTasl.join()
                +" spend time:"+(System.currentTimeMillis()-start)+"ms");
    }

    private static class SumTasl extends RecursiveTask<Integer> {
        private final static int THRESHOLD = MakeArray.ARRAY_LENGTH / 10;
        private int[] src;
        private int fromIndex;
        private int toIndex;

        public SumTasl(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            if (toIndex - fromIndex < THRESHOLD) {
                int count = 0;
                for (int i = fromIndex; i <= toIndex; i++) {
                    count = count + src[i];
                }
                return count;
            } else {
                int mid = (toIndex + fromIndex) / 2;
                SumTasl left = new SumTasl(src, fromIndex, mid);
                SumTasl right = new SumTasl(src, mid, toIndex);
                invokeAll(left, right);
                return left.join() + right.join();
            }
        }
    }
}
