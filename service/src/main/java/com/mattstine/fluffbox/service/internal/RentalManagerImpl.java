package com.mattstine.fluffbox.service.internal;

import com.mattstine.fluffbox.dao.RentalDao;
import com.mattstine.fluffbox.model.Customer;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.service.RentalManager;
import org.osgi.util.tracker.ServiceTracker;

public class RentalManagerImpl implements RentalManager {

    private ServiceTracker rentalDaoServiceTracker;

    public RentalManagerImpl(ServiceTracker rentalDaoServiceTracker) {
        this.rentalDaoServiceTracker = rentalDaoServiceTracker;
    }

    public Rental reserve(Speaker speaker, Kiosk kiosk, Customer customer) {
        try {
            return ((RentalDao) rentalDaoServiceTracker.waitForService(10000)).create(new Rental(speaker, kiosk, customer));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
