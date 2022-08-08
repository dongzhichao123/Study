package com.dongchao.Thread.DBPoolTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FindDiRsFile {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        File file = new File("D:/");
        ForlJointTest forlJointTest = new ForlJointTest(file);
        pool.execute(forlJointTest);
        System.out.println("Task is Running......");
        Thread.sleep(1);
        int otherWork = 0;
        for (int i = 0; i < 100; i++) {
            otherWork = otherWork + i;
        }
        System.out.println("Main Thread done sth......,otherWork=" + otherWork);
        forlJointTest.join();
    }

    public static class ForlJointTest extends RecursiveAction {
        List<ForlJointTest> task = new ArrayList<>();
        private File file;

        public ForlJointTest(File file) {
            this.file = file;
        }

        @Override
        protected void compute() {
            File[] fileArrayList = file.listFiles();
            if (fileArrayList != null) {

                for (File file1 : fileArrayList) {
                    if (file1.isDirectory()) {
                        task.add(new ForlJointTest(file1));
                    } else {
                        if (file1.getAbsolutePath().endsWith("txt")) {
                            System.out.println("txtFile:" + file1.getAbsoluteFile());
                        }
                    }
                }

            }

            if (!task.isEmpty()) {
//                List<ForlJointTest> tests = (List<ForlJointTest>) invokeAll(task);
                for (ForlJointTest ff : invokeAll(task)) {
                    ff.join();
                }


            }
        }
    }
}
