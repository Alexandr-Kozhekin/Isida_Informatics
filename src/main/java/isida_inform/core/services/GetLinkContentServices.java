package isida_inform.core.services;

import isida_inform.core.databases.LinkAnalysisImpl;
import isida_inform.core.requests.GetLinkContentRequest;
import isida_inform.core.services.validators.GetLinkContentValidator;
import isida_inform.core.responses.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GetLinkContentServices {

    @Autowired private LinkAnalysisImpl linkAnalysis;

    @Autowired private GetLinkContentValidator validator;

    public GetLinkContentResponse execute(GetLinkContentRequest request) {

        Set<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new GetLinkContentResponse(errors);
        }

        return new GetLinkContentResponse(linkAnalysis.getLinkContent(request.getUrl()));

    }
}
