package isida_inform.core.services;

import isida_inform.core.databases.InfoAboutLinkImpl;
import isida_inform.core.domain.InfoAboutLink;
import isida_inform.core.requests.LinkAnalysisRequest;
import isida_inform.core.services.validators.LinkAnalysisValidator;
import isida_inform.core.responses.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
@Transactional
public class LinkAnalysisServices {

    @Autowired private InfoAboutLinkImpl infoAboutLink;

    @Autowired private LinkAnalysisValidator validator;

    public LinkAnalysisResponse execute(LinkAnalysisRequest request) {

        Set<CoreError> errors = validator.validate(request);

        List<InfoAboutLink> infoAboutLinkList;

        if (!errors.isEmpty()) {
            return new LinkAnalysisResponse(errors);
        }

        infoAboutLinkList = infoAboutLink.linkAnalysis(request.getUrl());

        return new LinkAnalysisResponse(infoAboutLinkList);
    }
}
