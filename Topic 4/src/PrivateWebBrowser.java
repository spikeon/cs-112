public class PrivateWebBrowser extends WebBrowser {
    public void visit(String link){
        super.visit(link);
        clearHistory();
    }

    public String toString() {
        return "Current: " + current_page + " (Private browsing - no history)";
    }
}
