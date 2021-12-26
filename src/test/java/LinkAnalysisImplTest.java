import isida_inform.core.databases.LinkAnalysisImpl;
import isida_inform.core.domain.LinkContent;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class LinkAnalysisImplTest {

    private final LinkAnalysisImpl infoAboutLink = new LinkAnalysisImpl();

    @Test
    public void validTest() throws IOException, URISyntaxException {

        int expected = 40;

        List<LinkContent> infoAboutLinks = infoAboutLink.getLinkContent("https://metanit.com/");

        Assert.assertEquals(expected, infoAboutLinks.size());
        Assert.assertNotNull(infoAboutLinks);
    }

}
