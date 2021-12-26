package isida_inform.web_ui.web_controllers;


import isida_inform.core.requests.GetLinkContentRequest;
import isida_inform.core.responses.GetLinkContentResponse;
import isida_inform.core.services.GetLinkContentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

@Controller
public class GetLinkContentController {

    @Autowired private GetLinkContentServices services;

    @GetMapping(value = "/")
    public String showLinkAnalysisPage(ModelMap modelMap) {

        modelMap.addAttribute("request", new GetLinkContentRequest());

        return "linkAnalysis";
    }

    @PostMapping("/")
    public String processLinkAnalysisRequest(@ModelAttribute(value = "request") GetLinkContentRequest requests,
                                             ModelMap modelMap) {

        GetLinkContentResponse response = services.execute(requests);

        if (response.hasErrors()) {

            modelMap.addAttribute("errors", response.getErrors());
            return "linkAnalysis";

        } else {

            modelMap.addAttribute("LINK_INFO", response.getLinkContents());

        }

        return "linkAnalysis";
    }
}
