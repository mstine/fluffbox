package com.mattstine.fluffbox.kiosk;

import com.mattstine.fluffbox.model.Rental;

public interface KioskManager {

    void notifyHqOfRentalPickup(Rental rental);
    void notifyHqOfRentalReturn(Rental rental);
}
