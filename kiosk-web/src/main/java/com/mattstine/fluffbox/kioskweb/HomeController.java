package com.mattstine.fluffbox.kioskweb;

import com.mattstine.fluffbox.kiosk.KioskManager;
import com.mattstine.fluffbox.model.Customer;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import com.mattstine.fluffbox.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private KioskManager kioskManager;

    @RequestMapping("/home/index.html")
    public void index() {

    }

    @RequestMapping("/home/pickup.html")
    public String pickupRental() {
        Rental rental = new Rental(new Speaker(1L, "Matt", "Stine", "OSGi Head", "/images/matt_stine.jpg"),
                new Kiosk(1L, "Kroger (Outside)", "3095 Goodman Road E", "Southaven", "MS", "38672-8707"),
                new Customer());
        kioskManager.notifyHqOfRentalPickup(rental);
        return "home/index";
    }

    @RequestMapping("/home/return.html")
    public String returnRental() {
        Rental rental = new Rental(new Speaker(1L, "Matt", "Stine", "OSGi Head", "/images/matt_stine.jpg"),
                new Kiosk(1L, "Kroger (Outside)", "3095 Goodman Road E", "Southaven", "MS", "38672-8707"),
                new Customer());
        kioskManager.notifyHqOfRentalReturn(rental);
        return "home/index";
    }
}
