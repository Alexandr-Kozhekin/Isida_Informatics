package isida_inform.core.databases;

import isida_inform.core.domain.LinkContent;

import java.util.List;

public interface LinkAnalysisRepository {

    List<LinkContent> getLinkContent(String url);

}
