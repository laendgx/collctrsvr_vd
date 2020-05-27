package com.boco.commonCenter;

import com.boco.protocolBody.Identity;
import com.boco.protocolBody.Protocolbody;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

//@Component
//@RabbitListener(queues = "${sendQueueName}")
public class CommonSendQueueListener {
    private static final Logger logger= LoggerFactory.getLogger(CommonSendQueueListener.class);

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @Autowired
    private Environment env;

    @RabbitHandler
    public void process(String revdatabody) {
        try {
            System.out.println("队列collInfo接收-->" + revdatabody);
//            JSONObject jsonobject = JSONObject.fromObject(revdatabody);
//            Protocolbody Protocolbodytest = (Protocolbody) JSONObject.toBean(jsonobject, Protocolbody.class);
//            String busno = Protocolbodytest.getBusinessno();
//            System.out.println("CommonSendQueueListener_Protocolbodytest-->getBusinessno: " + busno);
//
//            String messageId = String.valueOf(UUID.randomUUID());
//            String messageData = "test message, hello!";
//            String curTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//            Protocolbody Protocolbodytemp = new Protocolbody();
//            Protocolbodytemp.setBusinessno("2345678");
//            Identity Identitytemp=new Identity();
//            Identitytemp.setDevId("22210001");
//            Identitytemp.setCreatetime(curTime);
//            Protocolbodytemp.setIdentity(Identitytemp);
//            JSONObject object = JSONObject.fromObject(Protocolbodytemp);
//            String jsonstr = object.toString();
//            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//            rabbitTemplate.setExchange(env.getProperty("exchangeName"));
//            rabbitTemplate.setRoutingKey(env.getProperty("sendQueueroutingkey"));
//            rabbitTemplate.convertAndSend(jsonstr);
        }catch ( Exception e) {
            logger.error("数据转发异常"+e.toString());
        }
    }
}
