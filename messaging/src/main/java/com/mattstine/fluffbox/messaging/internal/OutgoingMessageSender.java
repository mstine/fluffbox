package com.mattstine.fluffbox.messaging.internal;

import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;

public interface OutgoingMessageSender {
    void sendRentalNotificationToKiosk(Kiosk kiosk, Rental rental);
}
