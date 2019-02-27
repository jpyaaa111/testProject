package modeTest.instance;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程单例模式测试类
 * <p>多线程环境测试是否单例成立</p>
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : Test.java
 * @Description : 多线程单例模式测试类
 * @date : 2019年02月01日 13:49
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(10000);// 使用java并发库concurrent

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(InstanceTest3.getInstance());

                    latch.countDown();// 让latch中的数值减一
                }
            }).start();
        }

        // 主线程
        latch.await();// 阻塞当前线程直到latch中数值为零才执行

        long endTime = System.currentTimeMillis();
        float excTime = (float) (endTime - startTime) / 1000;
        System.out.println("***********************************************执行时间：" + excTime + "s");
    }
}