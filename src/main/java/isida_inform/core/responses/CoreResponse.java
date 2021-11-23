package isida_inform.core.responses;
;
import java.util.Set;

public class CoreResponse {

    private Set<CoreError> errors;

    private CoreError coreError;

    public CoreResponse() { }

    public CoreResponse(Set<CoreError> errors) {
        this.errors = errors;
    }

    public CoreResponse(CoreError coreError) {
        this.coreError = coreError;
    }

    public Set<CoreError> getErrors() {
        return errors;
    }

    public CoreError getCoreError() {
        return coreError;
    }

    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }

}
