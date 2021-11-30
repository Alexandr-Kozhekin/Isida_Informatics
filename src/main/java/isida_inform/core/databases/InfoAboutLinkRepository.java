package isida_inform.core.databases;

import isida_inform.core.domain.InfoAboutLink;

import java.util.List;

public interface InfoAboutLinkRepository {

    List<InfoAboutLink> linkAnalysis(String url);

}
