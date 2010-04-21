package com.mattstine.fluffbox.messaging.internal;

import com.mattstine.fluffbox.messaging.MessageService;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private OutgoingMessageSender outgoingMessageSender;


    public void notifyKioskOfRental(Kiosk kiosk, Rental rental) {
        outgoingMessageSender.sendRentalNotificationToKiosk(kiosk, rental);
    }


}
