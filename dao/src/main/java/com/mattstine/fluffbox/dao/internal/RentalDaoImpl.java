package com.mattstine.fluffbox.dao.internal;

import com.mattstine.fluffbox.dao.RentalDao;
import com.mattstine.fluffbox.model.Rental;

import java.util.Date;

public class RentalDaoImpl implements RentalDao {
    public Rental create(Rental rental) {
        rental.setId(1L);
        rental.setDateReserved(new Date());
        return rental;
    }
}
