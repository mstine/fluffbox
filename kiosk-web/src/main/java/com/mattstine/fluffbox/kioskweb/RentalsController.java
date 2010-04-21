package com.mattstine.fluffbox.kioskweb;

import com.mattstine.fluffbox.kiosk.MessageRepository;
import com.mattstine.fluffbox.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RentalsController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/rentals/show.html")
    @ModelAttribute("rentals")    
    public List<Rental> showReceivedRentals() {
        return messageRepository.getReceivedRentals();   
    }

}
