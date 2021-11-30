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
    public List<InfoAboutLink> linkAnalysis(String url) {

        List<InfoAboutLink> allInfo = new ArrayList<>();

        try {

            Document document = Jsoup.connect(url).get();

            List<Element> ele = document.select("a");

            long i = 1L;

            for (Element element : ele) {

                String links = element.absUrl("href");

                if (!links.isEmpty()) {

                    allInfo.add(new InfoAboutLink(i++, getDomainName(links), links));
                }
            }

        } catch (IOException  | URISyntaxException e) {

            e.printStackTrace();
        }

        return allInfo;
    }


    private String getDomainName(String url) throws URISyntaxException {

        URI uri = new URI(url);

        return uri.getHost();
    }

}
