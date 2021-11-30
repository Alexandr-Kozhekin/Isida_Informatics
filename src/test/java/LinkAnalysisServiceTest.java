import isida_inform.core.databases.InfoAboutLinkImpl;
import isida_inform.core.domain.InfoAboutLink;
import isida_inform.core.requests.LinkAnalysisRequest;
import isida_inform.core.services.LinkAnalysisServices;
import isida_inform.core.services.validators.LinkAnalysisValidator;

import isida_inform.core.responses.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LinkAnalysisServiceTest {

    @Mock
    private InfoAboutLinkImpl infoAboutLink;

    @Mock
    private LinkAnalysisValidator validator;

    @InjectMocks
    private LinkAnalysisServices services;

    @Test
    public void shouldCallMethodLinkAnalysisTest() {

        LinkAnalysisRequest request = new LinkAnalysisRequest("");

        LinkAnalysisResponse response = services.execute(request);

        Mockito.verify(infoAboutLink).linkAnalysis(request.getUrl());

        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    public void linkAnalysisWithInvalidRequestTest() {

        LinkAnalysisRequest request = new LinkAnalysisRequest(null);

        Set<CoreError> expected = Set.of(
                new CoreError("", "не должен быть пустым!")
        );

        Mockito.when(validator.validate(request)).thenReturn(expected);

        LinkAnalysisResponse response = services.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(infoAboutLink);
    }

}
