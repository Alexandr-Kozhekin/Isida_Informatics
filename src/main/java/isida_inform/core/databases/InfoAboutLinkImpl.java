package isida_inform.core.databases;

import isida_inform.core.domain.InfoAboutLink;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.net.*;
import java.util.*;

import org.jsoup.nodes.*;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InfoAboutLinkImpl implements InfoAboutLinkRepository {

    @Override
    public List<InfoAboutLink> linkAnalysis(String url) throws IOException, URISyntaxException {

        List<InfoAboutLink> allInfo = new ArrayList<>();

        Document document = Jsoup.connect(url).get();

        Elements elements = document.select("a");

        List<Element> ele = new ArrayList<>(elements);
        List<String> name = new ArrayList<>();

        long i = 1L;

        for (Element element : ele) {

            String links = element.absUrl("href");

            name.add(links);

            if (!links.isEmpty()) {

                allInfo.add(new InfoAboutLink(i++, getDomainName(links), links));
            }
        }

        return allInfo;
    }


    private String getDomainName(String url) throws URISyntaxException {

        URI uri = new URI(url);

        return uri.getHost();
    }

}
