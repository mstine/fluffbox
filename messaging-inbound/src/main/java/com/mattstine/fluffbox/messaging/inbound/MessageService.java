package com.mattstine.fluffbox.messaging.inbound;

import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;

public interface MessageService {

    void notifyHqOfRentalPickup(Rental rental);
    void notifyHqOfRentalReturn(Rental rental, Kiosk kiosk);

}
