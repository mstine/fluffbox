package com.mattstine.fluffbox.dao.internal;

import com.mattstine.fluffbox.dao.RentalDao;
import com.mattstine.fluffbox.model.Rental;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

public class RentalDaoImpl implements RentalDao {

    private static final Log log = LogFactory.getLog(RentalDaoImpl.class);


    public Rental create(Rental rental) {
        rental.setId(1L);
        rental.setDateReserved(new Date());
        return rental;
    }

    public void pickup(Rental rental) {
        log.info("Rental picked up: " + rental);
    }

    public void returnRental(Rental rental) {
        log.info("Rental returned: " + rental);
    }
}
