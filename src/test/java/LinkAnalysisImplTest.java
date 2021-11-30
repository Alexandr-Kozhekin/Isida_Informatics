import isida_inform.core.databases.InfoAboutLinkImpl;
import isida_inform.core.domain.InfoAboutLink;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LinkAnalysisImplTest {

    private final InfoAboutLinkImpl infoAboutLink = new InfoAboutLinkImpl();

    @Test
    public void validTest() {

        int expected = 40;

        List<InfoAboutLink> infoAboutLinks = infoAboutLink.linkAnalysis("https://metanit.com/");

        Assert.assertEquals(expected, infoAboutLinks.size());
        Assert.assertNotNull(infoAboutLinks);
    }

}
