import isida_inform.core.databases.LinkAnalysisImpl;
import isida_inform.core.requests.GetLinkContentRequest;
import isida_inform.core.services.GetLinkContentServices;
import isida_inform.core.services.validators.GetLinkContentValidator;

import isida_inform.core.responses.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LinkAnalysisServiceTest {

    @Mock
    private LinkAnalysisImpl infoAboutLink;

    @Mock
    private GetLinkContentValidator validator;

    @InjectMocks
    private GetLinkContentServices services;

    @Test
    public void shouldCallMethodLinkAnalysisTest() throws IOException, URISyntaxException {

        GetLinkContentRequest request = new GetLinkContentRequest("");

        GetLinkContentResponse response = services.execute(request);

        Mockito.verify(infoAboutLink).getLinkContent(request.getUrl());

        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    public void linkAnalysisWithInvalidRequestTest() {

        GetLinkContentRequest request = new GetLinkContentRequest(null);

        Set<CoreError> expected = Set.of(
                new CoreError("", "не должен быть пустым!")
        );

        Mockito.when(validator.validate(request)).thenReturn(expected);

        GetLinkContentResponse response = services.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(infoAboutLink);
    }

}
