package isida_inform.core.services.validators;

import isida_inform.core.requests.LinkAnalysisRequests;
import isida_inform.core.responses.CoreError;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LinkAnalysisValidator {

    public Set<CoreError> validate(LinkAnalysisRequests request) {
        Set<CoreError> errors = new HashSet<>();
        validateInputUrl(request).ifPresent(errors::add);
        validateUrl(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputUrl(LinkAnalysisRequests request) {
        return (request.getUrl() == null || request.getUrl().isEmpty())
                ? Optional.of(new CoreError("", "не должен быть пустым!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateUrl(LinkAnalysisRequests requests) {

        String url = requests.getUrl();

        return (!url.startsWith("http") && !url.startsWith("https"))
                ? Optional.of(new CoreError("url", "ошибка ввода адреса анализируемой страницы!"))
                : Optional.empty();
    }

}
