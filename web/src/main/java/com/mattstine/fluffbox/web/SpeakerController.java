package com.mattstine.fluffbox.web;

import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.service.SpeakerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpeakerController {

    @Autowired
    private SpeakerManager speakerManager;

    @RequestMapping("/speakers/browse.html")
    @ModelAttribute("speakers")
    public List<Speaker> browse() {
        return speakerManager.browse();
    }

    @RequestMapping("/speakers/show.html")
    @ModelAttribute("speaker")
    public Speaker show(@RequestParam Long id) {
        return speakerManager.get(id);
    }
}
