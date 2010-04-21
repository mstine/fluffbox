package com.mattstine.fluffbox.web;

import com.mattstine.fluffbox.model.Customer;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Rental;
import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.service.KioskManager;
import com.mattstine.fluffbox.service.RentalManager;
import com.mattstine.fluffbox.service.SpeakerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentalController {

    @Autowired
    private KioskManager kioskManager;

    @Autowired
    private RentalManager rentalManager;

    @Autowired
    private SpeakerManager speakerManager;

    @RequestMapping("/rental/reserve.html")
    @ModelAttribute("rental")
    public Rental reserve(@RequestParam Long speakerId, @RequestParam Long kioskId) {
        Speaker speaker = speakerManager.get(speakerId);
        Kiosk kiosk = kioskManager.get(kioskId);

        return rentalManager.reserve(speaker, kiosk, new Customer());
    }

}
