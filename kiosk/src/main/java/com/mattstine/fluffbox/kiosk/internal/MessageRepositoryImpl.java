package com.mattstine.fluffbox.kiosk.internal;

import com.mattstine.fluffbox.kiosk.MessageRepository;
import com.mattstine.fluffbox.model.Rental;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageRepositoryImpl implements MessageRepository {

    private List<Rental> receivedRentals;

    public MessageRepositoryImpl() {
        receivedRentals = new ArrayList<Rental>();
    }

    public List<Rental> getReceivedRentals() {
        return new ArrayList<Rental>(receivedRentals);
    }

    public void addReceivedRental(Rental rental) {
        receivedRentals.add(rental);
    }
}
