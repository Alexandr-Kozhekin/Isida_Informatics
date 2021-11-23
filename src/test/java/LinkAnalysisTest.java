import isida_inform.core.databases.InfoAboutLinkImpl;
import isida_inform.core.requests.LinkAnalysisRequests;
import isida_inform.core.services.LinkAnalysisServices;
import isida_inform.core.services.validators.LinkAnalysisValidator;

import isida_inform.core.responses.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LinkAnalysisTest {

    @Mock
    private InfoAboutLinkImpl infoAboutLink;

    @Mock
    private LinkAnalysisValidator validator;

    @InjectMocks
    private LinkAnalysisServices services;

    @Test
    public void linkAnalysisWithInvalidRequestTest() {

        LinkAnalysisRequests requests = new LinkAnalysisRequests(null);

        Set<CoreError> errors = new HashSet<>() {{
            add(new CoreError("", "не должен быть пустым!"));
        }};

        Mockito.lenient().when(validator.validate(requests)).thenReturn(errors);

        LinkAnalysisResponse response = services.execute(requests);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors()).isEqualTo(errors);

        Mockito.verifyNoInteractions(infoAboutLink);
    }

}
