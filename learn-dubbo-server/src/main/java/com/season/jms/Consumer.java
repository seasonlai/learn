package com.season.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
public class Consumer {

    static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    ThreadPoolExecutor executor;

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "sso.login")
    public void receiveQueue(String text) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                logger.info("====线程：{}；Consumer收到的报文为:{}", Thread.currentThread().getName(), text);
                System.out.println("Consumer收到的报文为:" + text);
            }
        });

    }
}  