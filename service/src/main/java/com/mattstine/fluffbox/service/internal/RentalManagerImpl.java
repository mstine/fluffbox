package com.mattstine.fluffbox.service.internal;

import com.mattstine.fluffbox.dao.RentalDao;
import com.mattstine.fluffbox.messaging.MessageService;
import com.mattstine.fluffbox.model.Customer;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.service.RentalManager;
import org.osgi.util.tracker.ServiceTracker;

public class RentalManagerImpl implements RentalManager {

    private ServiceTracker rentalDaoServiceTracker;
    private ServiceTracker messageServiceServiceTracker;

    public RentalManagerImpl(ServiceTracker rentalDaoServiceTracker, ServiceTracker messageServiceServiceTracker) {
        this.rentalDaoServiceTracker = rentalDaoServiceTracker;
        this.messageServiceServiceTracker = messageServiceServiceTracker;
    }

    public Rental reserve(Speaker speaker, Kiosk kiosk, Customer customer) {
        try {
            Rental rental = ((RentalDao) rentalDaoServiceTracker.waitForService(10000)).create(new Rental(speaker, kiosk, customer));
            ((MessageService) messageServiceServiceTracker.waitForService(10000)).notifyKioskOfRental(kiosk, rental);
            return rental;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pickup(Rental rental) {
        try {
            ((RentalDao) rentalDaoServiceTracker.waitForService(10000)).pickup(rental);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void returnRental(Rental rental, Kiosk kiosk) {
        try {
            ((RentalDao) rentalDaoServiceTracker.waitForService(10000)).returnRental(rental);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
