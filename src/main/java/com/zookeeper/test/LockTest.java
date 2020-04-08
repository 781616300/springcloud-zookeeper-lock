package com.zookeeper.test;

import com.zookeeper.service.OrderService;

/**
 * @Auther: Mr.Kong
 * @Date: 2020/4/8 10:33
 * @Description: 多线程模拟生成订单号使用Zookeeper分布式锁实现
 */
public class LockTest {

    public static void main(String[] args) {
        System.out.println("开始生成订单号......");
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(new OrderService()).start();
        }
        long end = System.currentTimeMillis();
        long result = end - begin;
        System.out.println("执行消耗时长：" + result / 1000 + "s");
    }
}
