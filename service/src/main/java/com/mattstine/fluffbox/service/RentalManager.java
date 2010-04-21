package com.mattstine.fluffbox.service;

import com.mattstine.fluffbox.model.Customer;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import com.mattstine.fluffbox.model.Speaker;

public interface RentalManager {
    Rental reserve(Speaker speaker, Kiosk kiosk, Customer customer);
    void pickup(Rental rental);
    void returnRental(Rental rental, Kiosk kiosk);
}
