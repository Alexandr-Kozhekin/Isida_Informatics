package isida_inform.core.services.validators;

import isida_inform.core.databases.InfoAboutLinkImpl;
import isida_inform.core.requests.LinkAnalysisRequest;
import isida_inform.core.responses.CoreError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LinkAnalysisValidator {

    @Autowired InfoAboutLinkImpl infoAboutLink;

    public Set<CoreError> validate(LinkAnalysisRequest request) {
        Set<CoreError> errors = new HashSet<>();

        validateInputUrl(request).ifPresent(errors::add);
        validateUrl(request).ifPresent(errors::add);
        zeroLinksReturn(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateInputUrl(LinkAnalysisRequest request) {

        return (request.getUrl() == null || request.getUrl().isEmpty())
                ? Optional.of(new CoreError("url", "не должен быть пустым!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateUrl(LinkAnalysisRequest requests) {

        return (!requests.getUrl().startsWith("http") && !requests.getUrl().startsWith("https"))
                ? Optional.of(new CoreError("url", "ошибка ввода адреса анализируемой страницы!"))
                : Optional.empty();
    }

    private Optional<CoreError> zeroLinksReturn(LinkAnalysisRequest requests) {

        return (infoAboutLink.linkAnalysis(requests.getUrl()).isEmpty())
                ? Optional.of(new CoreError("link", "анализируемая страница не содержет ссылок!"))
                : Optional.empty();
    }

}
