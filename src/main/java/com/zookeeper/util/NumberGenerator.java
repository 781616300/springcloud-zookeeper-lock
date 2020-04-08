package com.zookeeper.util;

import java.util.UUID;

/**
 * @Auther: Mr.Kong
 * @Date: 2020/4/8 10:26
 * @Description: 生成订单号
 */
public class NumberGenerator {

    public String getNumber() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
