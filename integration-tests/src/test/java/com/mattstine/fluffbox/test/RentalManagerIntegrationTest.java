package com.mattstine.fluffbox.test;

import com.mattstine.fluffbox.model.Customer;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.service.RentalManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.*;

@RunWith(JUnit4TestRunner.class)
public class RentalManagerIntegrationTest {

    @Inject
    private BundleContext bundleContext;

    @Configuration
    public static Option[] configuration() {
        return options(equinox(), provision(

                mavenBundle().groupId("com.mattstine.fluffbox").artifactId("model"),
                mavenBundle().groupId("com.mattstine.fluffbox").artifactId("dao"),
                mavenBundle().groupId("com.mattstine.fluffbox").artifactId("service")
        ));
    }

    private RentalManager retrieveRentalManager() throws InterruptedException {
        ServiceTracker tracker = new ServiceTracker(bundleContext,
                RentalManager.class.getName(), null);
        tracker.open();
        RentalManager rentalManager = (RentalManager) tracker.waitForService(5000);
        tracker.close();
        assertNotNull(rentalManager);
        return rentalManager;
    }

    @Test
    public void testReserve() throws InterruptedException {
        RentalManager rentalManager = retrieveRentalManager();
        Rental rental = rentalManager.reserve(new Speaker(1L, "Matt", "Stine", "OSGi Head", "/images/matt_stine.jpg"),
                new Kiosk(1L, "Kroger (Outside)", "3095 Goodman Road E", "Southaven", "MS", "38672-8707"),
                new Customer());
        assertEquals(Long.valueOf(1), rental.getId());
        assertNotNull(rental.getDateReserved());
    }
}
