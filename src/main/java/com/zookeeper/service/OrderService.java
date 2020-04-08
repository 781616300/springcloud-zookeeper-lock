package com.zookeeper.service;

import com.zookeeper.distrbutelock.ZookeeperDistrbuteLock;
import com.zookeeper.lock.CustomLock;
import com.zookeeper.util.NumberGenerator;

/**
 * @Auther: Mr.Kong
 * @Date: 2020/4/8 10:28
 * @Description:
 */
public class OrderService implements Runnable {

    private CustomLock customLock = new ZookeeperDistrbuteLock();

    @Override
    public void run() {
        getNumber();
    }

    public void getNumber() {
        try {
            customLock.getLock();
            String number = NumberGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + "生成订单号：" + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customLock.unLock();
        }
    }
}
