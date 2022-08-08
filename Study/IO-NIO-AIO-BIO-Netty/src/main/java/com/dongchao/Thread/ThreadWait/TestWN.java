package com.dongchao.Thread.ThreadWait;

/**
 * 测试wait/nitifiy
 */
public class TestWN {
    private static Express express = new Express(0, Express.CITY);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new CheckSite().start();
        }
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }
        try {
            Thread.sleep(1000);
            System.out.println("开始改变");
            express.changeKm();
            express.changeSite();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /*
   检查里程数变化的线程，不满足条件，线程一直等待
     */
    private static class CheckKm extends Thread {
        @Override
        public void run() {
            express.waitKM();
        }
    }

    private static class CheckSite extends Thread {
        @Override
        public void run() {
            express.waitSite();
        }
    }
}
