package com.mattstine.fluffbox.kiosk.internal;

import com.mattstine.fluffbox.model.Rental;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@Component
public class OutgoingMessageSenderImpl implements InitializingBean, OutgoingMessageSender {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    @Qualifier("pickup")
    private Queue pickupQueue;

    @Autowired
    @Qualifier("return")
    private Queue returnQueue;

    private JmsTemplate jmsTemplate;

    private static final Log log = LogFactory.getLog(OutgoingMessageSenderImpl.class);

    public void sendPickupNotificationToHq(Rental rental) {
        log.debug("In sendPickupNotificationToHq!");
        jmsTemplate.convertAndSend(pickupQueue, rental);
    }

    public void sendReturnNotificationToHq(Rental rental) {
        log.debug("In sendReturnNotificationToHq!");
        jmsTemplate.convertAndSend(returnQueue, rental);
    }

    public void afterPropertiesSet() throws Exception {
        jmsTemplate = new JmsTemplate(connectionFactory);
    }


}
