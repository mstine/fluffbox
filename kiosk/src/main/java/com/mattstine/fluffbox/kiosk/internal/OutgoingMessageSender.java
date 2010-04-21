package com.mattstine.fluffbox.kiosk.internal;

import com.mattstine.fluffbox.model.Rental;

public interface OutgoingMessageSender {
    void sendPickupNotificationToHq(Rental rental);

    void sendReturnNotificationToHq(Rental rental);
}
