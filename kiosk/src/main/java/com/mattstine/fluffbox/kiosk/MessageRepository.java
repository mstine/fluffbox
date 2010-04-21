package com.mattstine.fluffbox.kiosk;

import com.mattstine.fluffbox.model.Rental;

import java.util.List;

public interface MessageRepository {

    List<Rental> getReceivedRentals();
    void addReceivedRental(Rental rental);
}
