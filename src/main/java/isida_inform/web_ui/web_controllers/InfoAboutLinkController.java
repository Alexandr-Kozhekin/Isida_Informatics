package isida_inform.web_ui.web_controllers;


import isida_inform.core.requests.LinkAnalysisRequest;
import isida_inform.core.responses.LinkAnalysisResponse;
import isida_inform.core.services.LinkAnalysisServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

@Controller
public class InfoAboutLinkController {

    @Autowired private LinkAnalysisServices services;

    @GetMapping(value = "/")
    public String showLinkAnalysisPage(ModelMap modelMap) {

        modelMap.addAttribute("request", new LinkAnalysisRequest());

        return "linkAnalysis";
    }

    @PostMapping("/")
    public String processLinkAnalysisRequest(@ModelAttribute(value = "request") LinkAnalysisRequest requests,
                                             ModelMap modelMap) {

        LinkAnalysisResponse response = services.execute(requests);

        if (response.hasErrors()) {

            modelMap.addAttribute("errors", response.getErrors());
            return "linkAnalysis";

        } else {

            modelMap.addAttribute("LINK_INFO", response.getInfoAboutLinkList());

        }

        return "linkAnalysis";
    }
}
