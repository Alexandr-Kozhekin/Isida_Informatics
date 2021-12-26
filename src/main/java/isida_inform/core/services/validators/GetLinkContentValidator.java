package isida_inform.core.services.validators;

import isida_inform.core.databases.LinkAnalysisImpl;
import isida_inform.core.requests.GetLinkContentRequest;
import isida_inform.core.responses.CoreError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GetLinkContentValidator {

    @Autowired LinkAnalysisImpl linkAnalysis;

    public Set<CoreError> validate(GetLinkContentRequest request) {

        Set<CoreError> errors = new HashSet<>();

        validateInputUrl(request).ifPresent(errors::add);
        validateUrl(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateInputUrl(GetLinkContentRequest request) {

        return (request.getUrl() == null || request.getUrl().isEmpty())
                ? Optional.of(new CoreError("url", "не должен быть пустым!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateUrl(GetLinkContentRequest requests) {

        return (!requests.getUrl().startsWith("http") && !requests.getUrl().startsWith("https"))
                ? Optional.of(new CoreError("url", "ошибка ввода адреса анализируемой страницы!"))
                : Optional.empty();
    }

}
