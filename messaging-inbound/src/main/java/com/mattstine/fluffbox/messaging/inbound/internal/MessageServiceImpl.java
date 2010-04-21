package com.mattstine.fluffbox.messaging.inbound.internal;

import com.mattstine.fluffbox.messaging.inbound.MessageService;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import com.mattstine.fluffbox.service.RentalManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private RentalManager rentalManager;

    public void notifyHqOfRentalPickup(Rental rental) {
        rentalManager.pickup(rental);
    }

    public void notifyHqOfRentalReturn(Rental rental, Kiosk kiosk) {
        rentalManager.returnRental(rental, kiosk);
    }
}
