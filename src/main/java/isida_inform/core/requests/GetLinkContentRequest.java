package isida_inform.core.requests;

public class GetLinkContentRequest {

    private String url;

    public GetLinkContentRequest() {
    }

    public GetLinkContentRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
