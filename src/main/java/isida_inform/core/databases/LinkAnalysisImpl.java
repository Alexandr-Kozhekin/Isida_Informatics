package isida_inform.core.databases;

import isida_inform.core.domain.LinkContent;

import java.io.IOException;

import org.jsoup.Jsoup;

import java.net.*;
import java.util.*;

import org.jsoup.nodes.*;

import org.springframework.stereotype.Component;

@Component
public class LinkAnalysisImpl implements LinkAnalysisRepository {

    @Override
    public List<LinkContent> getLinkContent(String url) {

        List<LinkContent> linkContents = new ArrayList<>();
        
        List<Element> elements = getElementWithQueryA(url);

        long contentId = 1L;

        for (Element element : elements) {
            String address = element.absUrl("href");

            if (!address.isEmpty()) {
                linkContents.add(new LinkContent(contentId++, getDomainName(url), address));
            }
        }

        return linkContents;
    }
    
    private List<Element> getElementWithQueryA(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            return document.select("a");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private String getDomainName(String url) {
        try {
            URI domainName = new URI(url);
            return domainName.getHost();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "";
    }

}
