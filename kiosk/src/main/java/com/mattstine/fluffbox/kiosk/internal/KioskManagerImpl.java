package com.mattstine.fluffbox.kiosk.internal;

import com.mattstine.fluffbox.kiosk.KioskManager;
import com.mattstine.fluffbox.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KioskManagerImpl implements KioskManager {

    @Autowired
    OutgoingMessageSender outgoingMessageSender;

    public void notifyHqOfRentalPickup(Rental rental) {
        outgoingMessageSender.sendPickupNotificationToHq(rental);
    }

    public void notifyHqOfRentalReturn(Rental rental) {
        outgoingMessageSender.sendReturnNotificationToHq(rental);
    }
}
