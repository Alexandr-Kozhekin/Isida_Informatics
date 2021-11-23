package isida_inform.core.requests;

public class LinkAnalysisRequests {

    private String url;

    public LinkAnalysisRequests() {
    }

    public LinkAnalysisRequests(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
