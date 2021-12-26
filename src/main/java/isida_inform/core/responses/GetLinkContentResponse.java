package isida_inform.core.responses;

import isida_inform.core.domain.LinkContent;

import java.util.*;

public class GetLinkContentResponse extends CoreResponse{

    private List<LinkContent> linkContents;

    public GetLinkContentResponse(Set<CoreError> errors) {
        super(errors);
    }

    public GetLinkContentResponse(List<LinkContent> linkContents) {
        this.linkContents = linkContents;
    }

    public List<LinkContent> getLinkContents() {
        return linkContents;
    }
}
