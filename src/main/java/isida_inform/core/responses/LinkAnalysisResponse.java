package isida_inform.core.responses;

import isida_inform.core.domain.InfoAboutLink;

import java.util.List;
import java.util.Set;

public class LinkAnalysisResponse extends CoreResponse{

    private List<InfoAboutLink> infoAboutLinkList;

    public LinkAnalysisResponse(Set<CoreError> errors) {
        super(errors);
    }

    public LinkAnalysisResponse(List<InfoAboutLink> infoAboutLinkList) {
        this.infoAboutLinkList = infoAboutLinkList;
    }

    public List<InfoAboutLink> getInfoAboutLinkList() {
        return infoAboutLinkList;
    }
}
