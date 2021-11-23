package isida_inform.core.databases;

import isida_inform.core.domain.InfoAboutLink;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface InfoAboutLinkRepository {

    List<InfoAboutLink> linkAnalysis(String url) throws IOException, URISyntaxException;

}
