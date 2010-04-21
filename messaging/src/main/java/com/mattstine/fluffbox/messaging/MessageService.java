package com.mattstine.fluffbox.messaging;

import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;

public interface MessageService {

    void notifyKioskOfRental(Kiosk kiosk, Rental rental);
    
}
