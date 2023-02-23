package applications;

public enum ApplicationA implements Application {
    UAT("http://google.com"),
    DEV("http://herokuapp.com") {
    };
    String url;
    private ApplicationA(String url) { this.url = url; }

    @Override
    public String getUrl() {
        return url;
    }
}
