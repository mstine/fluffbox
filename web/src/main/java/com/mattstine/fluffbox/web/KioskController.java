package com.mattstine.fluffbox.web;

import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.service.KioskManager;
import com.mattstine.fluffbox.service.SpeakerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KioskController {

    @Autowired
    private SpeakerManager speakerManager;

    @Autowired
    private KioskManager kioskManager;    

    @RequestMapping("/kiosks/find.html")
    public ModelMap find(@RequestParam Long speakerId) {
        Speaker speaker = speakerManager.get(speakerId);

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("kiosks", kioskManager.findKiosksWhereAvailable(speaker));
        modelMap.addAttribute("speaker", speaker);

        return modelMap;
    }

}
