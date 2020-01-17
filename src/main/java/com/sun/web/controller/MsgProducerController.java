package com.sun.web.controller;

import com.sun.web.rocketmq.MsgProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.rocketmq.common.message.Message;
import java.io.UnsupportedEncodingException;

/**
 * @author ：suncj
 * @date ：2020/1/17 15:01
 */
@RestController
@RequestMapping("/rocketmq/my")
public class MsgProducerController {
    @Autowired  //注入消息生产者
    private MsgProducer service;
    /**
     * 功能描述：微信支付回调接口
     * @param msg 支付信息
     * @param tag 消息二级分类
     * @return
     */
    @GetMapping("order")
    public Object order(String msg,String tag) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {

        // 创建一个消息实例，包含 topic、tag 和 消息体
        Message message=new Message("testTopic",tag,msg.getBytes(RemotingHelper.DEFAULT_CHARSET));

        //调用方法==>返回消息体
        SendResult result =service.getProducer().send(message);

        System.out.println("发送响应消息ID:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());

        return null;
    }


}
