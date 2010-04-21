package com.mattstine.fluffbox.kiosk.internal;

import com.mattstine.fluffbox.kiosk.MessageRepository;
import com.mattstine.fluffbox.model.Rental;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncomingMessageListener {

    private static final Log log = LogFactory.getLog(IncomingMessageListener.class);

    @Autowired
    private MessageRepository messageRepository;

    public void receiveRentalNotification(Rental rental) {
        log.debug("Message received: " + rental);
        messageRepository.addReceivedRental(rental);
    }
}
