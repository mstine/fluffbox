package com.mattstine.fluffbox.messaging.inbound.internal;

import com.mattstine.fluffbox.messaging.inbound.MessageService;
import com.mattstine.fluffbox.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncomingMessageListener {

    @Autowired
    private MessageService messageService;

    public void receivePickupNotification(Rental rental) {
        messageService.notifyHqOfRentalPickup(rental);
    }

    public void receiveReturnNotification(Rental rental) {
        messageService.notifyHqOfRentalReturn(rental, rental.getKioskReturnedTo());
    }
}
