package com.mattstine.fluffbox.dao;

import com.mattstine.fluffbox.model.Rental;

public interface RentalDao {
    Rental create(Rental rental);
    void pickup(Rental rental);
    void returnRental(Rental rental);
}
