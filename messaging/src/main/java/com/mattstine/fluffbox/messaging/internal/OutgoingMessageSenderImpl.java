package com.mattstine.fluffbox.messaging.internal;

import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

@Component
public class OutgoingMessageSenderImpl implements OutgoingMessageSender, InitializingBean {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    @Qualifier("rentals")
    private Queue rentalsQueue;

    private JmsTemplate jmsTemplate;

    private static final Log log = LogFactory.getLog(OutgoingMessageSenderImpl.class);

    public void sendRentalNotificationToKiosk(final Kiosk kiosk, Rental rental) {
        log.debug("In sendRentalNotificationToKiosk!");
        jmsTemplate.convertAndSend(rentalsQueue, rental, new MessagePostProcessor() {
            public Message postProcessMessage(Message message) throws JMSException {
                message.setLongProperty("kiosk", kiosk.getId());
                return message;
            }
        });
    }

    public void afterPropertiesSet() throws Exception {
        jmsTemplate = new JmsTemplate(connectionFactory);
    }
}
