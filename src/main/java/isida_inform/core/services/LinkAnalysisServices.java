package isida_inform.core.services;

import isida_inform.core.databases.InfoAboutLinkImpl;
import isida_inform.core.domain.InfoAboutLink;
import isida_inform.core.requests.LinkAnalysisRequests;
import isida_inform.core.services.validators.LinkAnalysisValidator;
import isida_inform.core.responses.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import java.net.URISyntaxException;

import java.util.*;

@Component
@Transactional
public class LinkAnalysisServices {

    @Autowired private InfoAboutLinkImpl infoAboutLink;

    @Autowired private LinkAnalysisValidator validator;

    public LinkAnalysisResponse execute(LinkAnalysisRequests request) {

        Set<CoreError> errors = validator.validate(request);

        List<InfoAboutLink> infoAboutLinkList;

        if (!errors.isEmpty()) {
            return new LinkAnalysisResponse(errors);
        }

        try {

           infoAboutLinkList = infoAboutLink.linkAnalysis(request.getUrl());

        } catch (IOException  | URISyntaxException e) {

            errors.add(new CoreError("url", "ошибка ввода адреса анализируемой страницы!"));

            return new LinkAnalysisResponse(errors);
        }

        return new LinkAnalysisResponse(infoAboutLinkList);
    }
}
