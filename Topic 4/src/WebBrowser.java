public class WebBrowser {
    protected String current_page;
    private String last_page;

    public void visit(String link) {
        last_page = current_page;
        current_page = link;
    }

    public void clearHistory() {
        last_page = null;
    }

    public String getHistory() {
        return last_page;
    }

    public String toString() {
        return "Current: " + current_page + " Last page: " + last_page;
    }

}
